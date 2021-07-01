package pl.coderslab.charity.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {
    private final pl.coderslab.charity.entity.User user;

    public CurrentUser(
                       String username,
                       String email,
                       String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.coderslab.charity.entity.User user) {
        super(username, password, authorities);
        this.user = user;
    }
    public pl.coderslab.charity.entity.User getUser() {
        return user;
    }
}