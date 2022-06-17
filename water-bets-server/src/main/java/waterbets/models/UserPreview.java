package waterbets.models;

public class UserPreview {

    private int userId;
    private String firstName;
    private String lastName;
    private int totalPoolValue;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTotalPoolValue() {
        return totalPoolValue;
    }

    public void setTotalPoolValue(int totalPoolValue) {
        this.totalPoolValue = totalPoolValue;
    }
}
