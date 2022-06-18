package waterbets.doa.sql;

public class SqlStatement {

    public static final String INSERT_NEW_WATER_BET = "INSERT INTO water_bets (group_id, offerers_users_id, receivers_users_id, bet, offerers_droplets_on_the_line, " +
            "recipient_droplets_on_the_line, acceptance_status, bet_status, offered_time, accept_by_expiration_date) VALUES (:group_id, :offerers_users_id, :receivers_users_id, " +
            ":bet, :offerers_droplets_on_the_line, :recipient_droplets_on_the_line, :acceptance_status, :bet_status, :offered_time, :accept_by_expiration_date)";


}