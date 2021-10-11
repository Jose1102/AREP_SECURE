package co.edu.escuelaing.securityprimerlive;

public class User {

    private String mail;
    private String password;

    public User(){}

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
