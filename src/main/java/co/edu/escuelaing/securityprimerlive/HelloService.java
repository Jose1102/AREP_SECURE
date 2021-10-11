package co.edu.escuelaing.securityprimerlive;

import static spark.Spark.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class HelloService {


    public static void main(String... args){
        port(getPort());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystores/ecikeystore.p12", "123456", null, null);

        get("hello", (req,res) -> prueba("contraseña"));
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String prueba(String pass){

        MessageDigest mDigest = null;
        try {
            mDigest = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] result = mDigest.digest(pass.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
