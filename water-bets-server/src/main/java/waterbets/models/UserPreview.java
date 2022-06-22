package waterbets.models;

public class UserPreview {

    private int userId;
    private String userFullName;
    private int totalPoolValue;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public int getTotalPoolValue() {
        return totalPoolValue;
    }

    public void setTotalPoolValue(int totalPoolValue) {
        this.totalPoolValue = totalPoolValue;
    }
}
