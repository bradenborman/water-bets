package waterbets.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final OAuthUserService oauthUserService;
    private final LoginSuccessHandler loginSuccessHandler;

    public SecurityConfig(OAuthUserService oauthUserService, LoginSuccessHandler loginSuccessHandler) {
        this.oauthUserService = oauthUserService;
        this.loginSuccessHandler = loginSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();

        http.authorizeRequests()
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/h2-console/*", "/h2-console/**", "/console/**").permitAll() //Remove line when H2-Database is removed
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                .userService(oauthUserService)
                .and()
                .successHandler(loginSuccessHandler);
    }

}