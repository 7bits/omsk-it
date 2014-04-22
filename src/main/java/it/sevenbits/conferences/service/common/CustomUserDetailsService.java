package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Service which projects domain users on spring-security's users.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(final String login) {
        it.sevenbits.conferences.domain.User domainUser = userService.findUser(login);
        if (domainUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new User(
                domainUser.getLogin(),
                domainUser.getPassword(),
                domainUser.getEnabled(),
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(domainUser.getRole().getId().intValue())
        );
    }

    public Collection<? extends GrantedAuthority> getAuthorities(final Integer role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }

    public List<String> getRoles(final Integer role) {
        List<String> roles = new ArrayList<String>();
        //TODO: Kill this hardcode
        if (role == 3) {
            roles.add("ROLE_USER");
        }
        return roles;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(final List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}
