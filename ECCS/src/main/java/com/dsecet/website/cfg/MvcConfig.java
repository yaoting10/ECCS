package com.dsecet.website.cfg;

import com.dsecet.AbstractMvcConfig;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ViewResolver;

import static org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScan(basePackages = "com.dsecet.website", includeFilters = @Filter(Controller.class), useDefaultFilters = false)
public class MvcConfig extends AbstractMvcConfig{

    @Override
    protected String resourceContext(){
        return Constants.SERVLET_NAME;
    }

    @Bean(name = Constants.SERVLET_NAME + "ViewResolver")
    public ViewResolver jspResolver(){
        return super.jpaResolver();
    }

    @Bean
    public MessageSource messageSource(){
        return super.messageSource();
    }

    /**
     * Handles favicon.ico requests assuring no <code>404 Not Found</code> error is returned.
     */
    @Controller
    static class FaviconController{
        @RequestMapping("favicon.ico")
        String favicon(){
            return "forward:/resources/images/favicon.ico";
        }
    }
}
