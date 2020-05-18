package appLayer;

import dataLayer.DBUser;

public class User {

    public static boolean isValidUserCredentials(String sUserName, String sUserPassword) {
        DBUser dbUser = new DBUser();
        return dbUser.isValidUserLogin(sUserName, sUserPassword);
    }
}
