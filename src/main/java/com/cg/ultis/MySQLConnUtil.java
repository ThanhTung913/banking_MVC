package com.cg.ultis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtil {
    public static Connection getConnection() throws SQLException {
        String dbName = "banking_Database";
        String username = "root";
        String password = "Thanhtung913";
        return getSQLConnection(dbName, username, password);
    }

    public static Connection getSQLConnection( String dbName, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionURL = String.format("jdbc:mysql://localhost:3306/%s?useSSL=false", dbName);
            return DriverManager.getConnection(connectionURL, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex
        ) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
            }
        }
    }

//    private final String jdbcURL = "jdbc:mysql://localhost:3306/banking_Database?useSSL=false";
//    private final String jdbcUserName = "root";
//    private final String jdbcPassword = "Thanhtung913";
//    private final String SQL_UPDATE_PRODUCT = "UPDATE customers set full_name = ?, email = ?, phone = ?, address = ? where id = ?;";
//
//
//    protected Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }



}
