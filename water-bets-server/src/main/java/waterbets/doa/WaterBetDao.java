package waterbets.doa;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import waterbets.doa.rowmappers.WaterBetRowMapper;
import waterbets.models.WaterBet;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WaterBetDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public WaterBetDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<WaterBet> getWaterBetsByUser(int offeringUsersId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("offeringUsersId", offeringUsersId);
        String sql = "SELECT * FROM water_bets WHERE offerers_users_id = :offeringUsersId";
        return namedParameterJdbcTemplate.query(sql, params, new WaterBetRowMapper());
    }


    public void createAndSaveNewWaterBet(WaterBet waterBet) {
    }


    public List<WaterBet> selectWaterBetsByGroupId(int lobbyId) {
        return getWaterBetsByUser(0);
    }

}