package CRM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivitiesDAO {
    private Connection connection;

    public ActivitiesDAO(Connection connection) {
        this.connection = connection;
    }

    public void addActivity(Activities activity) throws SQLException {
        String query = "INSERT INTO Activities (related_type, related_id, activity_type, activity_date, notes) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, activity.getRelatedType());
            stmt.setInt(2, activity.getRelatedId());
            stmt.setString(3, activity.getActivityType());
            stmt.setDate(4, activity.getActivityDate());
            stmt.setString(5, activity.getNotes());
            stmt.executeUpdate();
        }
    }

    public List<Activities> getAllActivities() throws SQLException {
        List<Activities> activities = new ArrayList<>();
        String query = "SELECT * FROM Activities";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                activities.add(new Activities(
                        rs.getInt("activity_id"),
                        rs.getString("related_type"),
                        rs.getInt("related_id"),
                        rs.getString("activity_type"),
                        rs.getDate("activity_date"),
                        rs.getString("notes")
                ));
            }
        }
        return activities;
    }

    public void deleteActivity(int activityId) throws SQLException {
        String query = "DELETE FROM Activities WHERE activity_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, activityId);
            stmt.executeUpdate();
        }
    }
    
    public Activities getActivityById(int activityId) throws SQLException {
        String query = "SELECT * FROM Activities WHERE activity_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, activityId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Activities(
                            rs.getInt("activity_id"),
                            rs.getString("related_type"),
                            rs.getInt("related_id"),
                            rs.getString("activity_type"),
                            rs.getDate("activity_date"),
                            rs.getString("notes")
                    );
                }
            }
        }
        return null;
    }

    public void updateActivity(Activities activity) throws SQLException {
        String query = "UPDATE Activities SET related_type = ?, related_id = ?, activity_type = ?, activity_date = ?, notes = ? WHERE activity_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, activity.getRelatedType());
            stmt.setInt(2, activity.getRelatedId());
            stmt.setString(3, activity.getActivityType());
            stmt.setDate(4, activity.getActivityDate());
            stmt.setString(5, activity.getNotes());
            stmt.setInt(6, activity.getActivityId());
            stmt.executeUpdate();
        }
    }
}