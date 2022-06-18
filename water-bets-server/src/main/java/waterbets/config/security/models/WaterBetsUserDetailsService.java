package waterbets.config.security.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WaterBetsUserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(WaterBetsUserDetailsService.class);

    /*
        Do the logic to check to see if User exists and insert into database if not
     */
    public void processOAuthPostLogin(String username) {
        logger.info("{} is attempting to login", username);
    }
}