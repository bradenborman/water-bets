package waterbets.doa.sql;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import waterbets.models.WaterBet;

import static waterbets.utilities.DateTimeUtility.toStandardStorageFormat;

public class ParamsFactory {


    public static MapSqlParameterSource buildInsertNewWaterBet(WaterBet waterBet) {
        //Offered Date Time managed by defaulted timestamp on insert

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("group_id", waterBet.getGroupId());
        params.addValue("offerers_users_id", waterBet.getOfferersUsersId());
        params.addValue("receivers_users_id", waterBet.getReceiversUserId());
        params.addValue("bet", waterBet.getBet());
        params.addValue("offerers_droplets_on_the_line", waterBet.getOfferersDropletsOnTheLine());
        params.addValue("recipient_droplets_on_the_line", waterBet.getRecipientDropletsOnTheLine());
        params.addValue("acceptance_status", waterBet.getAcceptanceStatus().name());
        params.addValue("bet_status", waterBet.getBetStatus().name());
        params.addValue("accept_by_expiration_date_time", toStandardStorageFormat(waterBet.getAcceptByExpirationDate()));

        return params;
    }

}