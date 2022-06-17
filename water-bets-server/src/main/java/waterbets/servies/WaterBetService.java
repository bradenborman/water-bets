package waterbets.servies;

import waterbets.doa.WaterBetDao;
import waterbets.models.WaterBet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterBetService {

    private static final Logger logger = LoggerFactory.getLogger(WaterBetService.class);

    private final WaterBetDao waterBetDao;

    public WaterBetService(WaterBetDao waterBetDao) {
        this.waterBetDao = waterBetDao;
    }

    public List<WaterBet> getWaterBetsByUser(int offeringUsersId) {
        logger.info("Getting all water bets for user {}", offeringUsersId);
        return waterBetDao.getWaterBetsByUser(0);
    }


    public void createNewWaterBet(WaterBet waterBet) {
        logger.info("Creating a new water bet between {} and {}", waterBet.getOfferingUsersId(), waterBet.getReceiversUserId());
        waterBetDao.createNewWaterBet(waterBet);
    }

    public List<WaterBet> getWaterBetsByGroupId(int lobbyId) {
        logger.info("Getting all water bets for lobby {}", lobbyId);
        return waterBetDao.getWaterBetsByLobbyId(lobbyId);
    }
}