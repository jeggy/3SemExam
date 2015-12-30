package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Jógvan 29/12-2015 02:55.
 */
public class DBModel {

    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static String DB_NAME = "test";
    private static String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "toor";

    protected Connection con;

    protected void establishConnetion(){
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Database driver not found.");
        }
        try {
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed!.. " + DB_NAME + " Not Found installing db");
        }
    }

}
