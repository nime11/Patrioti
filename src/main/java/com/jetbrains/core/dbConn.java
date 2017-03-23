package com.jetbrains.core;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lenart on 19. 02. 2017.
 */
public class dbConn {
    //static reference to itself
    private static dbConn instance = new dbConn();
    public static final String URL = "jdbc:mysql://test.cgiwnuzpgiyc.us-west-2.rds.amazonaws.com/MuDataBase";
    public static final String USER = "Lenart";
    public static final String PASSWORD = "ht9EYwm7kE2AURbc";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    //private constructor
    private dbConn() {
        try {
            //Step 2: Load MySQL Java driver
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection createConnection() {

        Connection connection = null;
        try {
            //Step 3: Establish Java MySQL connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }

    public static Connection getConnection() {
        return createConnection();
    }
}

