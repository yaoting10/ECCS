package com.dsecet.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * User: liuchang
 * Date: 14-8-20
 */
public class AdminAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


    public AdminAuthenticationSuccessHandler( String targetUrl, boolean alwaysUse) {
        super();
        setDefaultTargetUrl(targetUrl);
        setAlwaysUseDefaultTargetUrl(alwaysUse);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
