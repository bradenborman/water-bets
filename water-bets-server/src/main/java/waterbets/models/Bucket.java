package waterbets.models;

public class Bucket {


    private int bucketId;
    private int groupId;
    private int userId;
    private int droplets;

    public int getBucketId() {
        return bucketId;
    }

    public void setBucketId(int bucketId) {
        this.bucketId = bucketId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDroplets() {
        return droplets;
    }

    public void setDroplets(int droplets) {
        this.droplets = droplets;
    }

}