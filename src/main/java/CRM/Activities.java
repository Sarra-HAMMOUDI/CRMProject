package CRM;

import java.sql.Date;

public class Activities {
    private int activityId;
    private String relatedType;
    private int relatedId;
    private String activityType;
    private Date activityDate;
    private String notes;

    // Constructors
    public Activities() {}

    public Activities(int activityId, String relatedType, int relatedId, String activityType, Date activityDate, String notes) {
        this.activityId = activityId;
        this.relatedType = relatedType;
        this.relatedId = relatedId;
        this.activityType = activityType;
        this.activityDate = activityDate;
        this.notes = notes;
    }

    // Getters and Setters
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getRelatedType() {
        return relatedType;
    }

    public void setRelatedType(String relatedType) {
        this.relatedType = relatedType;
    }

    public int getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(int relatedId) {
        this.relatedId = relatedId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Activities{" +
                "activityId=" + activityId +
                ", relatedType='" + relatedType + '\'' +
                ", relatedId=" + relatedId +
                ", activityType='" + activityType + '\'' +
                ", activityDate=" + activityDate +
                ", notes='" + notes + '\'' +
                '}';
    }
}