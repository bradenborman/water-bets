package waterbets.servies;

import waterbets.doa.WaterBetDao;
import waterbets.models.WaterBet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import waterbets.models.enums.AcceptanceStatus;

import java.util.List;

@Service
public class WaterBetService {

    private static final Logger logger = LoggerFactory.getLogger(WaterBetService.class);

    private final WaterBetDao waterBetDao;

    public WaterBetService(WaterBetDao waterBetDao) {
        this.waterBetDao = waterBetDao;
    }

    public List<WaterBet> selectWaterBetsOfferedByUser(int offeringUsersId) {
        logger.info("Getting all water bets for user {}", offeringUsersId);
        return waterBetDao.getWaterBetsByUser(offeringUsersId);
    }


    public void createAndSaveNewWaterBet(WaterBet waterBet) {
        logger.info("Creating a new water bet between {} and {}", waterBet.getOfferersUsersId(), waterBet.getReceiversUserId());

        waterBet.initializer()
                .initializeNewWaterBet();

        waterBetDao.createAndSaveNewWaterBet(waterBet);
    }

    public List<WaterBet> selectWaterBetsByGroupId(int lobbyId) {
        logger.info("Getting all water bets for lobby {}", lobbyId);
        return waterBetDao.selectWaterBetsByGroupId(lobbyId);
    }

    public void acknowledgeWaterBet(int waterBetId, boolean accept, int userId) {
        AcceptanceStatus acceptanceStatus = accept ? AcceptanceStatus.ACCEPTED : AcceptanceStatus.DECLINED;
        logger.info("User {} has {} bet {}", userId, acceptanceStatus.name(), waterBetId);
    }
}