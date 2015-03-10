package com.dsecet.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2014/9/15.
 */
public class WebsiteAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private String callBackUrl;
    private String errorPath;

    public WebsiteAuthenticationFailureHandler(String errorPath, String callBackUrl){
        super();
        this.callBackUrl = callBackUrl;
        this.errorPath = errorPath;
    }
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if(request.getParameter(callBackUrl) != null){
            this.setDefaultFailureUrl(this.errorPath + "&" + this.callBackUrl + "=" + request.getParameter(callBackUrl));
        }
        super.onAuthenticationFailure(request, response, exception);
    }
}
