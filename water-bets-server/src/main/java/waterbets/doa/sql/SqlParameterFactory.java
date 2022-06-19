package waterbets.doa.sql;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import waterbets.config.security.SecurityContextService;
import waterbets.models.WaterBet;
import waterbets.models.enums.AcceptanceStatus;
import waterbets.models.enums.BetStatus;

import static waterbets.utilities.DateTimeUtility.toStandardStorageFormat;

public class SqlParameterFactory {

    private  SqlParameterFactory()  {
        throw new IllegalStateException("Utility class");
    }

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

    public static MapSqlParameterSource rescindByWaterBetId(int waterBetId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("waterBetId", waterBetId);
        params.addValue("betStatus", BetStatus.RESCINDED.name());
        params.addValue("properStatusForRescinding", AcceptanceStatus.NOT_ACKNOWLEDGED.name());
        params.addValue("userId", SecurityContextService.accessLoggedInUser().getUserId());
        return params;
    }

    public static MapSqlParameterSource buildGroupPreviewsWithUser(int userId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", userId);
        return params;
    }
}