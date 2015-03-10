package com.dsecet.security;

import com.google.common.collect.Lists;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * user:yt
 * date:2014-11-10
 */
@Component
public class WebsiteUserDetailService implements UserDetailsService {



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        org.springframework.security.core.userdetails.User securityUser =
                new org.springframework.security.core.userdetails.User(
                        username,
                        "123",
                        true,
                        true,
                        true,
                        true,
                        Lists.newArrayList(grantedAuthority));
        return securityUser;
    }
}
