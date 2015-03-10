package com.dsecet.security;

import com.dsecet.core.persist.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: yt
 * Date: 14-11-10
 */
public class WebsiteAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private UserRepository userRepository;


    private String targetUrlParam;


    public WebsiteAuthenticationSuccessHandler(UserRepository userRepository, String targetUrl, boolean alwaysUse,String targetUrlParam) {
        super();
        this.userRepository = userRepository;
        setDefaultTargetUrl(targetUrl);
        setAlwaysUseDefaultTargetUrl(alwaysUse);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {


        super.onAuthenticationSuccess(request, response, authentication);
    }
}
