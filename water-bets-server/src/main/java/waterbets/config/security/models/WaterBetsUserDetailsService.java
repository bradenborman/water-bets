package waterbets.config.security.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import waterbets.exceptions.FailedNewUserInsertException;

import java.util.Optional;

@Service
public class WaterBetsUserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(WaterBetsUserDetailsService.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public WaterBetsUserDetailsService(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    //Do the logic to check to see if User exists and insert into database if not
    public void processOAuthPostLogin(WaterBetsOAuth2User oAuth2User) {
        logger.info("{} is attempting to login", oAuth2User.getFullName());

        int playerId = queryForUserByEmail(oAuth2User)
                .orElseGet(() -> insertFirstTimePlayer(oAuth2User));

        oAuth2User.setUserId(playerId);
    }


    private Optional<Integer> queryForUserByEmail(WaterBetsOAuth2User oAuth2User) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", oAuth2User.getEmail());

        String selectUserByEmail = "SELECT user_id FROM water_bets_users WHERE user_email = :email";
        try {
            return Optional.ofNullable(namedParameterJdbcTemplate.queryForObject(selectUserByEmail, params, Integer.class));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return Optional.empty();
        }
    }

    private int insertFirstTimePlayer(WaterBetsOAuth2User oAuth2User) {
        logger.info("First time logging on for {}", oAuth2User.getFullName());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", oAuth2User.getEmail());
        params.addValue("fullName", oAuth2User.getFullName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        String insertNewUser = "INSERT INTO water_bets_users (user_email, user_full_name) VALUES (:email, :fullName)";

        namedParameterJdbcTemplate.update(insertNewUser, params, keyHolder);

        Number pk = keyHolder.getKey();
        if (pk != null)
            return pk.intValue();

        throw new FailedNewUserInsertException("Failed to create a user entry for " + oAuth2User.getEmail());

    }

}