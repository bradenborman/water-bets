package waterbets.servies;

import org.springframework.stereotype.Service;
import waterbets.models.Group;
import waterbets.models.Lobby;
import waterbets.models.WaterBet;

import java.util.List;

@Service
public class LobbyService {

    private final WaterBetService waterBetService;
    private final GroupService groupService;

    public LobbyService(WaterBetService waterBetService, GroupService groupService) {
        this.waterBetService = waterBetService;
        this.groupService = groupService;
    }

    public Lobby getLobbyByGroupId(int groupId) {
        Lobby lobby = new Lobby();

        List<WaterBet> bets = waterBetService.getWaterBetsByGroupId(groupId);
        lobby.setWaterBets(bets);

        Group group = groupService.findGroupByGroupId(groupId);

        lobby.setGroup(group);


        return lobby;
    }
}