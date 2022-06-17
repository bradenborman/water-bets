package servies;

import waterbets.doa.WaterBetDao;
import waterbets.models.WaterBet;
import waterbets.models.enums.AcceptanceStatus;
import waterbets.models.enums.BetStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import waterbets.servies.WaterBetService;
import waterbets.utilities.DateTimeUtility;

import java.time.LocalDateTime;


class WaterBetServiceTest {

    WaterBetService waterBetService;

    @BeforeEach
    void setUp() {
        waterBetService = new WaterBetService(new WaterBetDao());
    }

    @Test
    void createNewWaterBetTest() {

        WaterBet waterBet = new WaterBet();

        waterBet.setOfferingUsersId(1);
        waterBet.setReceiversUserId(2);

        waterBet.setBet("Kenny Pickett will start week 6 or earlier");
        waterBet.setWagerAmount(50);

        waterBet.setAcceptanceStatus(AcceptanceStatus.NOT_ACKNOWLEDGE);
        waterBet.setBetStatus(BetStatus.OPEN);

        waterBet.setOfferedTime(DateTimeUtility.toStandardStorageFormat(LocalDateTime.now()));
        waterBet.setAcceptByExpirationDate(DateTimeUtility.toStandardStorageFormat(LocalDateTime.now().plusHours(8)));
        waterBet.setPublicBet(true);

        Assertions.assertDoesNotThrow(() -> {
            waterBetService.createNewWaterBet(waterBet);
        });

    }
}