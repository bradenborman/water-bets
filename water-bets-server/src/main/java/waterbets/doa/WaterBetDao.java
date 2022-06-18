package waterbets.doa;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import waterbets.doa.rowmappers.WaterBetRowMapper;
import waterbets.models.WaterBet;

import org.springframework.stereotype.Repository;
import waterbets.models.enums.WaterBetRetrievalStrategy;

import java.util.List;

@Repository
public class WaterBetDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public WaterBetDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<WaterBet> selectWaterBetsByStrategy(WaterBetRetrievalStrategy waterBetRetrievalStrategy, int id) {
        String sql = String.format("SELECT * FROM water_bets WHERE %s = :%s", waterBetRetrievalStrategy.getDbColumn(), waterBetRetrievalStrategy.getDbColumn());
        return namedParameterJdbcTemplate.query(sql, waterBetRetrievalStrategy.paramsByStrategy(id), new WaterBetRowMapper());
    }

    public void createAndSaveNewWaterBet(WaterBet waterBet) {
    }

}