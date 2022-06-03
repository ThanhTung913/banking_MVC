package com.cg.service;

import com.cg.model.Customer;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.cg.ultis.MySQLConnUtil.getConnection;

public class CustomerServicelmpl implements ICustomerService {
    Customer customer = new Customer();
    private static final String SELECT_ALL_CUSTOMER = "" +
            "SELECT " +
            " c.id, " +
            " c.full_name, " +
            " c.email, " +
            " c.phone, " +
            " c.address, " +
            " c.balance " +
            "FROM customers AS c " +
            "WHERE c.deleted = 0;";

    private static final String DELETE_CUSTOMER_SQL = "" +
            "DELETE " +
            "FROM customers " +
            "WHERE id = ?;";

    private static final String FIND_BY_ID = "" +
            "SELECT " +
            "id, " +
            "full_name, " +
            "email, " +
            "phone, " +
            "address " +
            "balance " +
            "FROM customers " +
            "WHERE id = ?;";

    private static final String UPDATE_CUSTOMER_SQL = "" +
            "UPDATE customers " +
            "SET " +
            "full_name = ?, " +
            "email= ?, " +
            "phone =? " +
            "WHERE id = ?;";

    private static final String ADD_CUSTOMER_SQL = "INSERT INTO customers (full_name, email, phone, address) VALUES (?,?,?,?);";



    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String full_name = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                BigDecimal balance = resultSet.getBigDecimal("balance");
                customers.add(new Customer(id, full_name, email, phone, address, balance));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                String full_name = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                BigDecimal balace = resultSet.getBigDecimal("balance");
                customer = new Customer(id, full_name, email, phone, address, balace);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return customer;

    }

    @Override
    public void create(Customer customer) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMER_SQL)
        ) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean update(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);
        ) {
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPhone());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

}
