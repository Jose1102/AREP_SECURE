package co.edu.escuelaing.securityprimerlive;

import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import com.google.common.hash.Hashing;

import spark.staticfiles.StaticFilesConfiguration;


import static spark.Spark.*;


public class HelloLogin {


    public static void main(String... args){


        port(getPort());
        Map<String,String> users=new HashMap<>();

        users.put("jose.castro@gmail.com",Hashing.sha256().hashString("123456789", StandardCharsets.UTF_8).toString());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystores/ecikeystore.p12", "123456", null, null);

        //get("hello", (req,res) -> "hello world!");

        Gson gson = new Gson();
        URLReader.start();




        before("secure/*", (req, response) ->{
            req.session(true);
            if(req.session().isNew()){
                req.session().attribute("Logged",false);
            }
            boolean auth=req.session().attribute("Logged");
            if(!auth){
                System.out.println("Entra");
                halt(401, "<h1>No estás autorizado, inicia sesión !</h1>");
            }

        });




        before("/index.html",((req, response) ->{
            req.session(true);
            if(req.session().isNew()){
                req.session().attribute("Logged",false);
            }
            boolean auth=req.session().attribute("Logged");
            if(auth){
                response.redirect("secure/inicio.html");
            }}));


        StaticFilesConfiguration staticHandler = new StaticFilesConfiguration();
        staticHandler.configure("/public");
        before((request, response) ->
                staticHandler.consume(request.raw(), response.raw()));

        get("/", (req, res) -> {
            res.redirect( "index.html");
            return "";
        });

        post("/login", (req, res) ->{
            req.session(true);
            User user = gson.fromJson(req.body(), User.class);
            if(Hashing.sha256().hashString(user.getPassword(), StandardCharsets.UTF_8).toString().equals(users.get(user.getMail()))){
                req.session().attribute("User",user.getMail());
                req.session().attribute("Logged",true);
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
