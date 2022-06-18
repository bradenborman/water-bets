package waterbets.config.security.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class WaterBetsOAuth2User implements OAuth2User {

    private final OAuth2User oauth2User;
    private int userId;

    public WaterBetsOAuth2User(OAuth2User oauth2User) {
        this.oauth2User = oauth2User;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oauth2User.getAuthorities();
    }

    /**
     * @deprecated (please use getFullName instead)
     **/
    @Override
    @Deprecated
    public String getName() {
        return oauth2User.getAttribute("name");
    }

    public String getFullName() {
        return oauth2User.getAttribute("name");
    }

    public String getEmail() {
        return oauth2User.<String>getAttribute("email");
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}