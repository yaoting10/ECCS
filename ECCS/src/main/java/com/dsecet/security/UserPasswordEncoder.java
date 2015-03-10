package com.dsecet.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * User: liuchang
 * Date: 14-8-20
 */
public class UserPasswordEncoder implements PasswordEncoder {

    // 此方法不会被DaoAuthenticationProvider调用, 所以在matches方法上会重新encode
    @Override
    public String encode(CharSequence rawPassword) {
        return "";
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return true;
    }
}
