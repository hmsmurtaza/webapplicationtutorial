package dataLayer;

import java.sql.*;

public class DBUser {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/webapplicationtutorial";

    // database credentials
    static final String USER = "webapplicationuser";
    static final String PASS = "webapplication123123";

    public boolean isValidUserLogin(String sUserName, String sUserPassword) {
        boolean isValidUser = false;

        Connection connection = null;
        Statement statement = null;
        String sql = "";

        try {
            // STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 3: Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL,USER, PASS);

            // STEP 4: Creating statement
            System.out.println("Creating statement");
            statement = connection.createStatement();

            sql = "SELECT * FROM users WHERE user_name=\"" +
                    sUserName + "\" AND user_password=\"" + sUserPassword + "\"";
            System.out.println(sql);

            ResultSet resultSet = statement.executeQuery(sql);

            // STEP 5: Extract data from result set
            if (resultSet.next()) {
                isValidUser = true;
            }

            // STEP 6: Clean-up environment
            resultSet.close();
            statement.close();
            connection.close();


        } catch (NullPointerException nullPointerException) {
            nullPointerException.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    connection.close();
                }
            }catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        System.out.println("Closing Database connection -- GoodBye");

        return isValidUser;
    }
}
