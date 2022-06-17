package waterbets.doa;

import waterbets.models.WaterBet;
import waterbets.models.enums.AcceptanceStatus;
import waterbets.models.enums.BetStatus;
import org.springframework.stereotype.Repository;
import waterbets.utilities.DateTimeUtility;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Repository
public class WaterBetDao {

    public List<WaterBet> getWaterBetsByUser(int offeringUsersId) {

        WaterBet waterBet2 = new WaterBet();

        waterBet2.setOfferingUsersId(1);
        waterBet2.setReceiversUserId(12);

        waterBet2.setBet("Texans will win more than 4.5 games this year");
        waterBet2.setWagerAmount(200);

        waterBet2.setAcceptanceStatus(AcceptanceStatus.ACCEPTED);
        waterBet2.setBetStatus(BetStatus.OPEN);

        waterBet2.setOfferedTime(DateTimeUtility.toStandardStorageFormat(LocalDateTime.now()));
        waterBet2.setAcceptByExpirationDate(DateTimeUtility.toStandardStorageFormat(LocalDateTime.now().plusHours(8)));
        waterBet2.setPublicBet(true);


        WaterBet waterBet = new WaterBet();

        waterBet.setOfferingUsersId(1);
        waterBet.setReceiversUserId(2);

        waterBet.setBet("Kenny Pickett will start week 6 or earlier");
        waterBet.setWagerAmount(50);

        waterBet.setAcceptanceStatus(AcceptanceStatus.NOT_ACKNOWLEDGE);
        waterBet.setBetStatus(BetStatus.OPEN);


        LocalDateTime startTime = LocalDateTime.of(2022, 5, 29, 8, 30, 0);
        waterBet.setOfferedTime(DateTimeUtility.toStandardStorageFormat(startTime));
        waterBet.setAcceptByExpirationDate(DateTimeUtility.toStandardStorageFormat(startTime.plusDays(5)));
        waterBet.setPublicBet(true);

        return Arrays.asList(waterBet, waterBet2);
    }


    public void createNewWaterBet(WaterBet waterBet) {
//        MapSqlParameterSource params = new MapSqlParameterSource();
    }


}