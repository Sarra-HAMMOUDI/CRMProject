package CRM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsDAO {
    private Connection connection;

    public AccountsDAO(Connection connection) {
        this.connection = connection;
    }

    public void addAccount(Accounts account) throws SQLException {
        String query = "INSERT INTO Accounts (customer_id, account_number, creation_date, account_type, balance) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, account.getCustomerId());
            stmt.setString(2, account.getAccountNumber());
            stmt.setDate(3, account.getCreationDate());
            stmt.setString(4, account.getAccountType());
            stmt.setDouble(5, account.getBalance());
            stmt.executeUpdate();
        }
    }

    public List<Accounts> getAllAccounts() throws SQLException {
        List<Accounts> accounts = new ArrayList<>();
        String query = "SELECT * FROM Accounts";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                accounts.add(new Accounts(
                        rs.getInt("account_id"),
                        rs.getInt("customer_id"),
                        rs.getString("account_number"),
                        rs.getDate("creation_date"),
                        rs.getString("account_type"),
                        rs.getDouble("balance")
                ));
            }
        }
        return accounts;
    }

    public void deleteAccount(int accountId) throws SQLException {
        String query = "DELETE FROM Accounts WHERE account_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, accountId);
            stmt.executeUpdate();
        }
    }
    
    
    public Accounts getAccountById(int accountId) throws SQLException {
        String query = "SELECT * FROM Accounts WHERE account_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, accountId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Accounts(
                            rs.getInt("account_id"),
                            rs.getInt("customer_id"),
                            rs.getString("account_number"),
                            rs.getDate("creation_date"),
                            rs.getString("account_type"),
                            rs.getDouble("balance")
                    );
                }
            }
        }
        return null;
    }

    public void updateAccount(Accounts account) throws SQLException {
        String query = "UPDATE Accounts SET customer_id = ?, account_number = ?, creation_date = ?, account_type = ?, balance = ? WHERE account_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, account.getCustomerId());
            stmt.setString(2, account.getAccountNumber());
            stmt.setDate(3, account.getCreationDate());
            stmt.setString(4, account.getAccountType());
            stmt.setDouble(5, account.getBalance());
            stmt.setInt(6, account.getAccountId());
            stmt.executeUpdate();
        }
    }
}