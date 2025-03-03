package CRM;

import java.sql.Date;

public class Opportunities {
    private int opportunityId;
    private int customerId;
    private String description;
    private double estimatedValue;
    private String stage;
    private Date createdDate;

    // Constructors
    public Opportunities() {}

    public Opportunities(int opportunityId, int customerId, String description, double estimatedValue, String stage, Date createdDate) {
        this.opportunityId = opportunityId;
        this.customerId = customerId;
        this.description = description;
        this.estimatedValue = estimatedValue;
        this.stage = stage;
        this.createdDate = createdDate;
    }

    // Getters and Setters
    public int getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(int opportunityId) {
        this.opportunityId = opportunityId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(double estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Opportunities{" +
                "opportunityId=" + opportunityId +
                ", customerId=" + customerId +
                ", description='" + description + '\'' +
                ", estimatedValue=" + estimatedValue +
                ", stage='" + stage + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}