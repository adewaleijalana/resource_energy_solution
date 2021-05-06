package com.resource.energy.security;

import com.resource.energy.domain.AppRole;
import com.resource.energy.domain.AppUser;
import com.resource.energy.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AppUserService appUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        System.err.println("username: " + username);
        String password = authentication.getCredentials().toString();
        System.err.println("password: " + password);

        AppUser user = appUserService.getRepository().findByUsername(username);

        return new UsernamePasswordAuthenticationToken(user, password,
                buildSimpleGrantedAuthorities(user.getRoles()));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final List<AppRole> roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (AppRole role : roles) {
            System.err.println("role name: " + role.getName());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
}
