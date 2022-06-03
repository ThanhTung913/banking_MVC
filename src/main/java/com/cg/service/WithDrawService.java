package com.cg.service;

import com.cg.model.Customer;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WithDrawService implements IWithDrawService {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/banking_Database?useSSL=false";
    private final String jdbcUserName = "root";
    private final String jdbcPassword = "Thanhtung913";
    private final String SQL_SELECT_CUSTOMER = "SELECT * FROM customers;";
    private final String WITHDRAW_SQL = "SET @message = '?'" +
            "    CALL banking_Database.SP_Withdrawl(?, ?, @message);" +
            "    SELECT @message;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Customer> selectAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_CUSTOMER);
        ) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String address = rs.getString(5);
                java.util.Date timeOrder = new Date(rs.getTimestamp(3).getTime());
                Customer customer = new Customer(id, name, email, phone, address);
                customers.add(customer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer selectCustomer(int id) {
        return null;
    }

    @Override
    public boolean withdraw(int id, BigDecimal amount, String message) {
        try {
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(WITHDRAW_SQL);
            callableStatement.setInt(1, id);
            callableStatement.setBigDecimal(2, amount);
            callableStatement.setString(3, message);
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
