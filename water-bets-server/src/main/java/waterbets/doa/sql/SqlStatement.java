package waterbets.doa.sql;

public class SqlStatement {

    public static final String INSERT_NEW_WATER_BET = "INSERT INTO water_bets (group_id, offerers_users_id, receivers_users_id, bet, offerers_droplets_on_the_line, " +
            "recipient_droplets_on_the_line, acceptance_status, bet_status, accept_by_expiration_date_time) VALUES (:group_id, :offerers_users_id, :receivers_users_id, " +
            ":bet, :offerers_droplets_on_the_line, :recipient_droplets_on_the_line, :acceptance_status, :bet_status, :accept_by_expiration_date_time)";


    public static final String RESCIND_BY_WATER_BET_ID = "UPDATE water_bets set bet_status = :betStatus, closed_date_time = CURRENT_TIMESTAMP " +
            "WHERE water_bet_id = :waterBetId AND acceptance_status = :properStatusForRescinding AND offerers_users_id = :userId";

}