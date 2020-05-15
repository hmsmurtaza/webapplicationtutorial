package appLayer;

public class User {

    public static boolean isValidUserCredentials(String sUserName, String sUserPassword) {
        if (sUserName.equals("shoaib") && sUserPassword.equals("123123")) {
            return true;
        }
        return false;
    }
}
