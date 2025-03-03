package CRM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeadsDAO {
    private Connection connection;

    public LeadsDAO(Connection connection) {
        this.connection = connection;
    }

    public void addLead(Leads lead) throws SQLException {
        String query = "INSERT INTO Leads (name, email, phone, source, status, employee_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, lead.getName());
            stmt.setString(2, lead.getEmail());
            stmt.setString(3, lead.getPhone());
            stmt.setString(4, lead.getSource());
            stmt.setString(5, lead.getStatus());
            stmt.setInt(6, lead.getEmployeeId());
            stmt.executeUpdate();
        }
    }

    public List<Leads> getAllLeads() throws SQLException {
        List<Leads> leads = new ArrayList<>();
        String query = "SELECT * FROM Leads";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                leads.add(new Leads(
                        rs.getInt("lead_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("source"),
                        rs.getString("status"),
                        rs.getInt("employee_id")
                ));
            }
        }
        return leads;
    }

    public void deleteLead(int leadId) throws SQLException {
        String query = "DELETE FROM Leads WHERE lead_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, leadId);
            stmt.executeUpdate();
        }
    }
    
    public Leads getLeadById(int leadId) throws SQLException {
        String query = "SELECT * FROM Leads WHERE lead_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, leadId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Leads(
                            rs.getInt("lead_id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            rs.getString("source"),
                            rs.getString("status"),
                            rs.getInt("employee_id")
                    );
                }
            }
        }
        return null;
    }

    public void updateLead(Leads lead) throws SQLException {
        String query = "UPDATE Leads SET name = ?, email = ?, phone = ?, source = ?, status = ?, employee_id = ? WHERE lead_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, lead.getName());
            stmt.setString(2, lead.getEmail());
            stmt.setString(3, lead.getPhone());
            stmt.setString(4, lead.getSource());
            stmt.setString(5, lead.getStatus());
            stmt.setInt(6, lead.getEmployeeId());
            stmt.setInt(7, lead.getLeadId());
            stmt.executeUpdate();
        }
    }
}