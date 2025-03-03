package CRM;

public class Leads {
    private int leadId;
    private String name;
    private String email;
    private String phone;
    private String source;
    private String status;
    private int employeeId;

    // Constructors
    public Leads() {}

    public Leads(int leadId, String name, String email, String phone, String source, String status, int employeeId) {
        this.leadId = leadId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.source = source;
        this.status = status;
        this.employeeId = employeeId;
    }

    // Getters and Setters
    public int getLeadId() {
        return leadId;
    }

    public void setLeadId(int leadId) {
        this.leadId = leadId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Leads{" +
                "leadId=" + leadId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", source='" + source + '\'' +
                ", status='" + status + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }
}