package edu.escuelaing.arep.service.app;
import static spark.Spark.*;

/**
 * @author Jose Maria Castro Ortega
 * Clase App, clase principal
 */
public class App 
{
    /**
     * Metodo estatico main donde inicia el App, inicia la conexión con keystores
     * @param args que es una lista de String
     */
    public static void main(String... args){
        port(getPort());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystores/ecikeystore.p12", "123456", null, null);

        get("hello", (req,res) -> "hello world!");
    }

    /**
     * Metodo estatico getPort
     * @return un número entero que es el 4567 que es el puerto en donde corre el localhost
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
