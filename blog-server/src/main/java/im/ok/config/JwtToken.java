package im.ok.config;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Feng, Ge 2021/4/14 0014 14:47
 */
public class JwtToken implements AuthenticationToken {
    private String token;
    public JwtToken(String token) {
        this.token = token;
    }
    @Override
    public Object getPrincipal() {
        return token;
    }
    @Override
    public Object getCredentials() {
        return token;
    }
}
