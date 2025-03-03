package CRM;

import java.sql.Date;

public class Campaigns {
    private int campaignId;
    private String name;
    private Date startDate;
    private Date endDate;
    private double budget;
    private int employeeId;

    // Constructors
    public Campaigns() {}

    public Campaigns(int campaignId, String name, Date startDate, Date endDate, double budget, int employeeId) {
        this.campaignId = campaignId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.employeeId = employeeId;
    }

    // Getters and Setters
    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Campaigns{" +
                "campaignId=" + campaignId +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", budget=" + budget +
                ", employeeId=" + employeeId +
                '}';
    }
}