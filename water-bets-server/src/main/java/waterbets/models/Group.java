package waterbets.models;

import java.util.List;

public class Group {

    private int groupId;
    private String groupName;
    private String passwordToJoin;

    private int maxDropletBet;
    private List<UserPreview> members;

    private List<WaterBet> waterBets;


    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPasswordToJoin() {
        return passwordToJoin;
    }

    public int getMaxDropletBet() {
        return maxDropletBet;
    }

    public void setMaxDropletBet(int maxDropletBet) {
        this.maxDropletBet = maxDropletBet;
    }

    public void setPasswordToJoin(String passwordToJoin) {
        this.passwordToJoin = passwordToJoin;
    }

    public List<UserPreview> getMembers() {
        return members;
    }

    public void setMembers(List<UserPreview> members) {
        this.members = members;
    }

    public List<WaterBet> getWaterBets() {
        return waterBets;
    }

    public void setWaterBets(List<WaterBet> waterBets) {
        this.waterBets = waterBets;
    }
}