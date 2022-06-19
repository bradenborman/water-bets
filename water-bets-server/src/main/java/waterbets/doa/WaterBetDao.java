package waterbets.doa;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import waterbets.doa.rowmappers.WaterBetRowMapper;
import waterbets.doa.sql.SqlParameterFactory;
import waterbets.doa.sql.SqlStatement;
import waterbets.exceptions.FailureToRescindWaterBetException;
import waterbets.models.WaterBet;

import org.springframework.stereotype.Repository;
import waterbets.models.enums.WaterBetRetrievalStrategy;

import java.util.List;

@Repository
public class WaterBetDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //TODO -> move to property
    private final int DAYS_FOR_CLOSED_BETS_TO_APPEAR = 14;

    public WaterBetDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<WaterBet> selectWaterBetsByStrategy(WaterBetRetrievalStrategy waterBetRetrievalStrategy, int id) {
        String sql = String.format("SELECT * FROM water_bets WHERE %s = :%s " +
                        "AND (bet_status != 'CLOSED' OR closed_date_time > CURRENT_DATE - %d) " +
                        "AND bet_status != 'RESCINDED'",

                waterBetRetrievalStrategy.getDbColumn(),
                waterBetRetrievalStrategy.getDbColumn(),
                DAYS_FOR_CLOSED_BETS_TO_APPEAR
        );
        return namedParameterJdbcTemplate.query(sql, waterBetRetrievalStrategy.paramsByStrategy(id), new WaterBetRowMapper());
    }

    public void saveNewWaterBet(WaterBet waterBet) {
        namedParameterJdbcTemplate.update(SqlStatement.INSERT_NEW_WATER_BET, SqlParameterFactory.buildInsertNewWaterBet(waterBet));
    }

    public void rescindByWaterBetId(int waterBetId) {
        int rowsEffectedCount = namedParameterJdbcTemplate.update(SqlStatement.RESCIND_BY_WATER_BET_ID, SqlParameterFactory.rescindByWaterBetId(waterBetId));
        if (rowsEffectedCount == 0)
            throw new FailureToRescindWaterBetException("Failed to rescind any rows for water bet " + waterBetId);
    }

}