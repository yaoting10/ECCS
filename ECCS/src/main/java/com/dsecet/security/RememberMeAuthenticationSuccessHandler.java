package com.dsecet.security;

import com.dsecet.core.persist.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by
 * $ {USER} : yt
 * $ {DATE} : 2014/10/11.
 */
public class RememberMeAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private UserRepository userRepository;

    public RememberMeAuthenticationSuccessHandler(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
