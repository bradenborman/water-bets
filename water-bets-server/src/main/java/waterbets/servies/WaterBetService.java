package waterbets.servies;

import waterbets.doa.WaterBetDao;
import waterbets.models.WaterBet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import waterbets.models.enums.AcceptanceStatus;
import waterbets.models.enums.WaterBetRetrievalStrategy;

import java.util.List;

@Service
public class WaterBetService {

    private static final Logger logger = LoggerFactory.getLogger(WaterBetService.class);

    private final WaterBetDao waterBetDao;

    public WaterBetService(WaterBetDao waterBetDao) {
        this.waterBetDao = waterBetDao;
    }

    //Hands group, offerer, and receiver
    public List<WaterBet> selectWaterBetsByStrategy(WaterBetRetrievalStrategy waterBetRetrievalStrategy, int id) {
        return waterBetDao.selectWaterBetsByStrategy(waterBetRetrievalStrategy, id);
    }

    public void saveNewWaterBet(WaterBet waterBet) {
        logger.info("Creating a new water bet between {} and {}", waterBet.getOfferersUsersId(), waterBet.getReceiversUserId());



        waterBetDao.saveNewWaterBet(waterBet);
    }

    public void acknowledgeWaterBet(int waterBetId, boolean accept, int userId) {
        AcceptanceStatus acceptanceStatus = accept ? AcceptanceStatus.ACCEPTED : AcceptanceStatus.DECLINED;
        logger.info("User {} has {} bet {}", userId, acceptanceStatus.name(), waterBetId);
    }
}