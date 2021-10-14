package co.edu.escuelaing.securityprimerlive;

/**
 * @author Jose Maria Castro Ortega
 */
public class User {

    private String mail;
    private String password;

    /**
     * Constructor de la clase User
     */
    public User(){}

    /**
     * Metodo getMail
     * @return un String que es el correo del User
     */
    public String getMail() {
        return mail;
    }

    /**
     * Metodo getPassword
     * @return String que es la clave del User
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodo setMail
     * @param mail que es el String nuevo a cambiar del mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Metodo setPassword
     * @param password que es el String nuevo a cambiar del password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
