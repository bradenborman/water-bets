package waterbets.doa.rowmappers;

import org.springframework.jdbc.core.RowMapper;
import waterbets.models.WaterBet;
import waterbets.models.enums.AcceptanceStatus;
import waterbets.models.enums.BetStatus;
import waterbets.models.enums.WaterBetWinner;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WaterBetRowMapper implements RowMapper<WaterBet> {

    @Override
    public WaterBet mapRow(ResultSet rs, int rowNum) throws SQLException {
        WaterBet waterBet = new WaterBet();

        waterBet.setWaterBetId(rs.getInt("water_bet_id"));
        waterBet.setGroupId(rs.getInt("group_id"));
        waterBet.setOfferersUsersId(rs.getInt("offerers_users_id"));
        waterBet.setReceiversUserId(rs.getInt("receivers_users_id"));
        waterBet.setBet(rs.getString("bet"));
        waterBet.setOfferersDropletsOnTheLine(rs.getInt("offerers_droplets_on_the_line"));
        waterBet.setRecipientDropletsOnTheLine(rs.getInt("recipient_droplets_on_the_line"));
        waterBet.setAcceptanceStatus(AcceptanceStatus.findOrNull(rs.getString("acceptance_Status")));
        waterBet.setBetStatus(BetStatus.findOrNull(rs.getString("bet_status")));
        waterBet.setOfferedTime(rs.getString("offered_time"));
        waterBet.setAcceptByExpirationDate(rs.getString("accept_by_expiration_date"));
        waterBet.setOfferersPick(WaterBetWinner.findOrNull(rs.getString("offerers_pick")));
        waterBet.setReceiversPick(WaterBetWinner.findOrNull(rs.getString("receivers_pick")));
        waterBet.setDecidedWinner(WaterBetWinner.findOrNull(rs.getString("decided_winner")));

        return waterBet;
    }

}
