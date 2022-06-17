package waterbets.models;

import java.util.List;

public class Lobby {

    private Group group;
    private List<WaterBet> waterBets;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<WaterBet> getWaterBets() {
        return waterBets;
    }

    public void setWaterBets(List<WaterBet> waterBets) {
        this.waterBets = waterBets;
    }
}