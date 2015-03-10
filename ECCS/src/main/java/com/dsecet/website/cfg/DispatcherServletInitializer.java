package com.dsecet.website.cfg;

import com.dsecet.AbstractAnnotationServletInitializer;
import com.dsecet.ApplicationConfig;
import com.dsecet.core.cfg.JpaConfig;
import com.dsecet.security.MultiHttpSecurityConfig;

public class DispatcherServletInitializer extends AbstractAnnotationServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class<?>[]{ApplicationConfig.class, JpaConfig.class, MultiHttpSecurityConfig.class};
    }
    @Override
    protected String getServletName(){
        return Constants.SERVLET_NAME;
    }

    @Override
    protected String[] getServletMappings(){
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getServletConfigClasses(){
        return new Class<?>[]{MvcConfig.class};
    }

}