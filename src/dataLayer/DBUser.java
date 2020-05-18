package dataLayer;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DBUser {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/webapplicationtutorial";

    // database credentials
    static final String USER = "webapplicationuser";
    static final String PASS = "webapplication123123";

    Connection connection = null;
    Statement statement = null;
    boolean isValidUser = false;

    public boolean isValidUserLogin(String sUserName, String sUserPassword) {

        String sql = "";

        try {
            // STEP 2: Register JDBC driver
            registerJDBCDriver(JDBC_DRIVER);

            // STEP 3: Open a connection
            openAConnection(DB_URL, USER, PASS);

            // STEP 4: Creating statement
            createStatement();

            // execute query
            ResultSet resultSet = executeQuery(sUserName,  sUserPassword);

            // STEP 5: Extract data from result set
            isValidUser = extractDataFromResultSet(resultSet);

            // STEP 6: Clean-up environment
            closeConnections(resultSet, statement, connection);

        } catch (NullPointerException nullPointerException) {
            nullPointerException.printStackTrace();
        }catch (Exception exception) {
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

    private boolean extractDataFromResultSet(ResultSet resultSet) {

        try {
            if (resultSet.next()) {
                isValidUser = true;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return isValidUser;
    }

    private ResultSet executeQuery(String sUserName, String sUserPassword) {
        String sql = "";
        sql = "SELECT * FROM users WHERE user_name=\"" +
                sUserName + "\" AND user_password=\"" + sUserPassword + "\"";
        System.out.println(sql);


        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return resultSet;
    }

    private void createStatement() {
        System.out.println("Creating statement");
        try {
            statement = connection.createStatement();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    private void openAConnection(String dbUrl, String user, String pass) {
        System.out.println("Connecting to database...");
        try {
            connection = DriverManager.getConnection(dbUrl,user, pass);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    private void registerJDBCDriver(String jdbcDriverName) {
        try {
            Class.forName(jdbcDriverName);
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }

    private void closeConnections(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
