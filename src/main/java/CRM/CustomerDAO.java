package CRM;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private Connection connection;

    public CustomerDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert a new customer
    public void insertCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO Customer (person_id, company_name, registration_date, total_spent) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, customer.getPersonId());
            statement.setString(2, customer.getCompanyName());
            statement.setDate(3, customer.getRegistrationDate());
            statement.setDouble(4, customer.getTotalSpent());
            statement.executeUpdate();

            // Retrieve the generated customer_id
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customer.setCustomerId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Retrieve all customers
    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM Customer";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("person_id"),
                        resultSet.getString("company_name"),
                        resultSet.getDate("registration_date"),
                        resultSet.getDouble("total_spent")
                );
                customers.add(customer);
            }
        }
        return customers;
    }

    // Retrieve a customer by ID
    public Customer getCustomerById(int customerId) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Customer(
                            resultSet.getInt("customer_id"),
                            resultSet.getInt("person_id"),
                            resultSet.getString("company_name"),
                            resultSet.getDate("registration_date"),
                            resultSet.getDouble("total_spent")
                    );
                }
            }
        }
        return null; // Return null if no customer is found
    }

    // Update a customer
    public void updateCustomer(Customer customer) throws SQLException {
        String sql = "UPDATE Customer SET person_id = ?, company_name = ?, registration_date = ?, total_spent = ? WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customer.getPersonId());
            statement.setString(2, customer.getCompanyName());
            statement.setDate(3, customer.getRegistrationDate());
            statement.setDouble(4, customer.getTotalSpent());
            statement.setInt(5, customer.getCustomerId());
            statement.executeUpdate();
        }
    }

    // Delete a customer
    public void deleteCustomer(int customerId) throws SQLException {
        String sql = "DELETE FROM Customer WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customerId);
            statement.executeUpdate();
        }
    }
}