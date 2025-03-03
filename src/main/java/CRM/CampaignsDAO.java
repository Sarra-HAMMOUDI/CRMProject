package CRM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CampaignsDAO {
    private Connection connection;

    public CampaignsDAO(Connection connection) {
        this.connection = connection;
    }

    public void addCampaign(Campaigns campaign) throws SQLException {
        String query = "INSERT INTO Campaigns (name, start_date, end_date, budget, employee_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, campaign.getName());
            stmt.setDate(2, campaign.getStartDate());
            stmt.setDate(3, campaign.getEndDate());
            stmt.setDouble(4, campaign.getBudget());
            stmt.setInt(5, campaign.getEmployeeId());
            stmt.executeUpdate();
        }
    }

    public List<Campaigns> getAllCampaigns() throws SQLException {
        List<Campaigns> campaigns = new ArrayList<>();
        String query = "SELECT * FROM Campaigns";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                campaigns.add(new Campaigns(
                        rs.getInt("campaign_id"),
                        rs.getString("name"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getDouble("budget"),
                        rs.getInt("employee_id")
                ));
            }
        }
        return campaigns;
    }

    public void deleteCampaign(int campaignId) throws SQLException {
        String query = "DELETE FROM Campaigns WHERE campaign_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, campaignId);
            stmt.executeUpdate();
        }
    }
    public Campaigns getCampaignById(int campaignId) throws SQLException {
        String query = "SELECT * FROM Campaigns WHERE campaign_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, campaignId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Campaigns(
                            rs.getInt("campaign_id"),
                            rs.getString("name"),
                            rs.getDate("start_date"),
                            rs.getDate("end_date"),
                            rs.getDouble("budget"),
                            rs.getInt("employee_id")
                    );
                }
            }
        }
        return null;
    }

    public void updateCampaign(Campaigns campaign) throws SQLException {
        String query = "UPDATE Campaigns SET name = ?, start_date = ?, end_date = ?, budget = ?, employee_id = ? WHERE campaign_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, campaign.getName());
            stmt.setDate(2, campaign.getStartDate());
            stmt.setDate(3, campaign.getEndDate());
            stmt.setDouble(4, campaign.getBudget());
            stmt.setInt(5, campaign.getEmployeeId());
            stmt.setInt(6, campaign.getCampaignId());
            stmt.executeUpdate();
        }
    }
}