package com.dsecet.security;


import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * User: liuchang
 * Date: 14-8-14
 */
public class AdminPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return "";
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return true;
    }
}
