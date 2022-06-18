package waterbets.config.security.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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

        //query the database and select by email, make optional, if null, insert and create new
        // user and return primary key and set on WaterBetsOAuth2User
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", oAuth2User.getEmail());

        

//        Optional<Integer> existingWaterBetPlayerId = Optional.ofNullable(namedParameterJdbcTemplate.queryForObject("", params, Integer.class));
//
//        int playerId = existingWaterBetPlayerId
//                .orElse(insertFirstTimePlayer(oAuth2User));
//
//        oAuth2User.setUserId(playerId);
    }


    private int insertFirstTimePlayer(WaterBetsOAuth2User oAuth2User) {
        logger.info("First time logging on for {}", oAuth2User.getFullName());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", oAuth2User.getEmail());
        params.addValue("fullName", oAuth2User.getFullName());

        //TODO select the pk of the insert

        Integer id = namedParameterJdbcTemplate.queryForObject("", params, Integer.class);

        if (id != null)
            return id;

        throw new FailedNewUserInsertException("Failed to create a user entry for " + oAuth2User.getEmail());

    }

}