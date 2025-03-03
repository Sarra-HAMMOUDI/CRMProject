package CRM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert a new employee
    public void insertEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO Employee (person_id, job_title, department, salary, hire_date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employee.getPersonId());
            statement.setString(2, employee.getJobTitle());
            statement.setString(3, employee.getDepartment());
            statement.setDouble(4, employee.getSalary());
            statement.setDate(5, employee.getHireDate());
            statement.executeUpdate();
        }
    }

    // Retrieve all employees
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employee";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("employee_id"),
                        resultSet.getInt("person_id"),
                        resultSet.getString("job_title"),
                        resultSet.getString("department"),
                        resultSet.getDouble("salary"),
                        resultSet.getDate("hire_date")
                );
                employees.add(employee);
            }
        }
        return employees;
    }

    // Retrieve an employee by ID
    public Employee getEmployeeById(int employeeId) throws SQLException {
        String sql = "SELECT * FROM Employee WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employeeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Employee(
                            resultSet.getInt("employee_id"),
                            resultSet.getInt("person_id"),
                            resultSet.getString("job_title"),
                            resultSet.getString("department"),
                            resultSet.getDouble("salary"),
                            resultSet.getDate("hire_date")
                    );
                }
            }
        }
        return null; // Return null if no employee is found
    }

    // Update an employee
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE Employee SET person_id = ?, job_title = ?, department = ?, salary = ?, hire_date = ? WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employee.getPersonId());
            statement.setString(2, employee.getJobTitle());
            statement.setString(3, employee.getDepartment());
            statement.setDouble(4, employee.getSalary());
            statement.setDate(5, employee.getHireDate());
            statement.setInt(6, employee.getEmployeeId());
            statement.executeUpdate();
        }
    }

    // Delete an employee
    public void deleteEmployee(int employeeId) throws SQLException {
        String sql = "DELETE FROM Employee WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employeeId);
            statement.executeUpdate();
        }
    }
}