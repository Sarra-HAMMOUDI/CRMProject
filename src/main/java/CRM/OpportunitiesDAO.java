package CRM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OpportunitiesDAO {
    private Connection connection;

    public OpportunitiesDAO(Connection connection) {
        this.connection = connection;
    }

    public void addOpportunity(Opportunities opportunity) throws SQLException {
        String query = "INSERT INTO Opportunities (customer_id, description, estimated_value, stage, created_date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, opportunity.getCustomerId());
            stmt.setString(2, opportunity.getDescription());
            stmt.setDouble(3, opportunity.getEstimatedValue());
            stmt.setString(4, opportunity.getStage());
            stmt.setDate(5, opportunity.getCreatedDate());
            stmt.executeUpdate();
        }
    }

    public List<Opportunities> getAllOpportunities() throws SQLException {
        List<Opportunities> opportunities = new ArrayList<>();
        String query = "SELECT * FROM Opportunities";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                opportunities.add(new Opportunities(
                        rs.getInt("opportunity_id"),
                        rs.getInt("customer_id"),
                        rs.getString("description"),
                        rs.getDouble("estimated_value"),
                        rs.getString("stage"),
                        rs.getDate("created_date")
                ));
            }
        }
        return opportunities;
    }

    public void deleteOpportunity(int opportunityId) throws SQLException {
        String query = "DELETE FROM Opportunities WHERE opportunity_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, opportunityId);
            stmt.executeUpdate();
        }
    }
    
    public Opportunities getOpportunityById(int opportunityId) throws SQLException {
        String query = "SELECT * FROM Opportunities WHERE opportunity_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, opportunityId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Opportunities(
                            rs.getInt("opportunity_id"),
                            rs.getInt("customer_id"),
                            rs.getString("description"),
                            rs.getDouble("estimated_value"),
                            rs.getString("stage"),
                            rs.getDate("created_date")
                    );
                }
            }
        }
        return null;
    }

    public void updateOpportunity(Opportunities opportunity) throws SQLException {
        String query = "UPDATE Opportunities SET customer_id = ?, description = ?, estimated_value = ?, stage = ?, created_date = ? WHERE opportunity_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, opportunity.getCustomerId());
            stmt.setString(2, opportunity.getDescription());
            stmt.setDouble(3, opportunity.getEstimatedValue());
            stmt.setString(4, opportunity.getStage());
            stmt.setDate(5, opportunity.getCreatedDate());
            stmt.setInt(6, opportunity.getOpportunityId());
            stmt.executeUpdate();
        }
    }
}