package waterbets.models.enums;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public enum WaterBetRetrievalStrategy {

    USER_OFFERED("offerers_users_id"),
    OFFERED_TO_USER("receivers_users_id"),
    OFFERS_WITH_GROUP("group_id");

    private final String dbColumn;

    WaterBetRetrievalStrategy(String dbColumn) {
        this.dbColumn = dbColumn;
    }

    public String getDbColumn() {
        return dbColumn;
    }

    public MapSqlParameterSource paramsByStrategy(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(this.dbColumn, id);
        return params;
    }

}
