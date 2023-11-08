package sample;

public class User {
    public static String account;
    public static String password;
    public static boolean login = false;

    public static void setLogin(boolean sign){
        login = sign;
    }

    public static boolean getLogin(){
        return login;
    }
}
