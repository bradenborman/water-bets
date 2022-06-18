package waterbets.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import waterbets.config.security.models.WaterBetsOAuth2User;
import waterbets.config.security.models.WaterBetsUserDetailsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final WaterBetsUserDetailsService userDetailsService;

    public LoginSuccessHandler(WaterBetsUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        WaterBetsOAuth2User oauthUser = (WaterBetsOAuth2User) authentication.getPrincipal();
        userDetailsService.processOAuthPostLogin(oauthUser.getFullName());
        response.sendRedirect("/");
    }

}