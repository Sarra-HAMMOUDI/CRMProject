package CRM;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private Connection connection;

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert a new person
    public void insertPerson(Person person) throws SQLException {
        String sql = "INSERT INTO Person (first_name, last_name, email, phone, address) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setString(3, person.getEmail());
            statement.setString(4, person.getPhone());
            statement.setString(5, person.getAddress());
            statement.executeUpdate();
        }
    }

    // Retrieve all persons
    public List<Person> getAllPersons() throws SQLException {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT * FROM Person";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Person person = new Person(
                        resultSet.getInt("person_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")
                );
                persons.add(person);
            }
        }
        return persons;
    }

    // Retrieve a person by ID
    public Person getPersonById(int personId) throws SQLException {
        String sql = "SELECT * FROM Person WHERE person_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, personId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Person(
                            resultSet.getInt("person_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email"),
                            resultSet.getString("phone"),
                            resultSet.getString("address")
                    );
                }
            }
        }
        return null; // Return null if no person is found
    }

    // Retrieve persons by last name
    public List<Person> getPersonsByLastName(String lastName) throws SQLException {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT * FROM Person WHERE last_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lastName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Person person = new Person(
                            resultSet.getInt("person_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email"),
                            resultSet.getString("phone"),
                            resultSet.getString("address")
                    );
                    persons.add(person);
                }
            }
        }
        return persons;
    }

    // Update a person
    public void updatePerson(Person person) throws SQLException {
        String sql = "UPDATE Person SET first_name = ?, last_name = ?, email = ?, phone = ?, address = ? WHERE person_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setString(3, person.getEmail());
            statement.setString(4, person.getPhone());
            statement.setString(5, person.getAddress());
            statement.setInt(6, person.getPersonId());
            statement.executeUpdate();
        }
    }

    // Delete a person (with associated Customer records)
    public void deletePerson(int personId) throws SQLException {
        // First, delete associated Customer records
        String deleteCustomerSQL = "DELETE FROM Customer WHERE person_id = ?";
        try (PreparedStatement customerStatement = connection.prepareStatement(deleteCustomerSQL)) {
            customerStatement.setInt(1, personId);
            customerStatement.executeUpdate();
        }

        // Then, delete the Person record
        String deletePersonSQL = "DELETE FROM Person WHERE person_id = ?";
        try (PreparedStatement personStatement = connection.prepareStatement(deletePersonSQL)) {
            personStatement.setInt(1, personId);
            personStatement.executeUpdate();
        }
    }
}