package CRM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketsDAO {
    private Connection connection;

    public TicketsDAO(Connection connection) {
        this.connection = connection;
    }

    public void addTicket(Tickets ticket) throws SQLException {
        String query = "INSERT INTO Tickets (customer_id, issue_description, status, created_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ticket.getCustomerId());
            stmt.setString(2, ticket.getIssueDescription());
            stmt.setString(3, ticket.getStatus());
            stmt.setDate(4, ticket.getCreatedDate());
            stmt.executeUpdate();
        }
    }

    public List<Tickets> getAllTickets() throws SQLException {
        List<Tickets> tickets = new ArrayList<>();
        String query = "SELECT * FROM Tickets";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                tickets.add(new Tickets(
                        rs.getInt("ticket_id"),
                        rs.getInt("customer_id"),
                        rs.getString("issue_description"),
                        rs.getString("status"),
                        rs.getDate("created_date")
                ));
            }
        }
        return tickets;
    }

    public void deleteTicket(int ticketId) throws SQLException {
        String query = "DELETE FROM Tickets WHERE ticket_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ticketId);
            stmt.executeUpdate();
        }
    }
    
    public Tickets getTicketById(int ticketId) throws SQLException {
        String query = "SELECT * FROM Tickets WHERE ticket_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ticketId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Tickets(
                            rs.getInt("ticket_id"),
                            rs.getInt("customer_id"),
                            rs.getString("issue_description"),
                            rs.getString("status"),
                            rs.getDate("created_date")
                    );
                }
            }
        }
        return null;
    }

    public void updateTicket(Tickets ticket) throws SQLException {
        String query = "UPDATE Tickets SET customer_id = ?, issue_description = ?, status = ?, created_date = ? WHERE ticket_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ticket.getCustomerId());
            stmt.setString(2, ticket.getIssueDescription());
            stmt.setString(3, ticket.getStatus());
            stmt.setDate(4, ticket.getCreatedDate());
            stmt.setInt(5, ticket.getTicketId());
            stmt.executeUpdate();
        }
    }
}