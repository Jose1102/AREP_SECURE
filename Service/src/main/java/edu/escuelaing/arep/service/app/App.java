package edu.escuelaing.arep.service.app;
import static spark.Spark.*;


public class App 
{
    public static void main(String... args){
        port(getPort());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystores/ecikeystore.p12", "123456", null, null);

        get("hello", (req,res) -> "hello world!");
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
