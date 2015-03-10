package com.dsecet.security;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.servlet.ServletContext;


/**
 * User: liuchang
 * Date: 14-8-14
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        OpenEntityManagerInViewFilter oeiv = new OpenEntityManagerInViewFilter();

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        MultipartFilter multipartFilter = new MultipartFilter();

        insertFilters(servletContext, characterEncodingFilter);
        insertFilters(servletContext, oeiv);
        insertFilters(servletContext, multipartFilter);
    }


}
