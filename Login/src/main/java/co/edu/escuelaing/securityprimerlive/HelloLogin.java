package co.edu.escuelaing.securityprimerlive;

import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import com.google.common.hash.Hashing;

import static spark.Spark.*;


public class HelloLogin {


    public static void main(String... args){
        //staticFileLocation("/public");
        port(getPort());
        Map<String,String> users=new HashMap<>();

        users.put("jose.castro@gmail.com",Hashing.sha256().hashString("123456789", StandardCharsets.UTF_8).toString());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystores/ecikeystore.p12", "123456", null, null);

        //get("hello", (req,res) -> "hello world!");

        Gson gson = new Gson();
        URLReader.start();


        get("/", (req, res) -> {
            res.redirect( "index.html");
            return "";
        });

        before("secure/*", (req, response) ->{
            req.session(true);
            if(req.session().isNew()){
                req.session().attribute("secureLogged",false);
            }
            boolean auth=req.session().attribute("secureLogged");
            if(!auth){
                halt(401, "<h1>No estás autorizado, inicia sesión !</h1>");
            }});


        before("/index.html",((req, response) ->{
            req.session(true);
            if(req.session().isNew()){
                req.session().attribute("secureLogged",false);
            }
            boolean auth=req.session().attribute("secureLogged");
            if(auth){
                response.redirect("secure/inicio.html");
            }}));



        post("/login", (req, res) ->{
            req.session(true);
            User user = gson.fromJson(req.body(), User.class);
            if(Hashing.sha256().hashString(user.getPassword(), StandardCharsets.UTF_8).toString().equals(users.get(user.getMail()))){
                req.session().attribute("User",user.getMail());
                req.session().attribute("Loged",true);
            }
            else{
                return "Correo o contraseña incorrecta";
            }
            return "";
        });

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }


}
