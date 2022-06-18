package waterbets.config.security;

import org.springframework.security.core.context.SecurityContextHolder;
import waterbets.config.security.models.WaterBetsOAuth2User;

public class SecurityContextService {


    public static WaterBetsOAuth2User accessLoggedInUser() {
        return (WaterBetsOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}