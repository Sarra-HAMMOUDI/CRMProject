package CRM;


import java.math.BigDecimal;
import java.sql.Date;

public class Customer {
    private int customerId;
    private int personId;
    private String companyName;
    private Date registrationDate;
    private Double totalSpent;

    // Constructors
   // public Customer() {}

    public Customer(int customerId, int personId, String companyName, Date registrationDate, Double bigDecimal) {
        this.customerId = customerId;
        this.personId = personId;
        this.companyName = companyName;
        this.registrationDate = registrationDate;
        this.totalSpent = bigDecimal;
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Double totalSpent) {
        this.totalSpent = totalSpent;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", personId=" + personId +
                ", companyName='" + companyName + '\'' +
                ", registrationDate=" + registrationDate +
                ", totalSpent=" + totalSpent +
                '}';
    }
}