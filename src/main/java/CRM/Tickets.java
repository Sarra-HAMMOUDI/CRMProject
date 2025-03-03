package CRM;

import java.sql.Date;

public class Tickets {
    private int ticketId;
    private int customerId;
    private String issueDescription;
    private String status;
    private Date createdDate;

    // Constructors
    public Tickets() {}

    public Tickets(int ticketId, int customerId, String issueDescription, String status, Date createdDate) {
        this.ticketId = ticketId;
        this.customerId = customerId;
        this.issueDescription = issueDescription;
        this.status = status;
        this.createdDate = createdDate;
    }

    // Getters and Setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketId=" + ticketId +
                ", customerId=" + customerId +
                ", issueDescription='" + issueDescription + '\'' +
                ", status='" + status + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}