package com.dsecet;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * Created with Test
 * User : yt
 * Date : 2014/11/11.
 */
public abstract class AbstractMvcConfig extends WebMvcConfigurationSupport{
    private static final String BASE_MESSAGE_SOURCE = "/WEB-INF/i18n/message";
    private static final String BASE_RESOURCE_LOCATION = "/resource/";
    private static final String BASE_RESOURCE_HANDLER = BASE_RESOURCE_LOCATION + "**";

    private static final String MESSAGE_SOURCE = "/WEB-INF/%s/i18n/messages";
    private static final String VIEWS = "/WEB-INF/%s/views/";
    private static final String RESOURCE_LOCATION = "/resource/%s/";
    private static final String RESOURCE_HANDLER = RESOURCE_LOCATION + "**";

    protected abstract String resourceContext();

    public ViewResolver jpaResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(String.format(VIEWS, resourceContext()));
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping(){
        RequestMappingHandlerMapping requestMappingHandlerMapping = super.requestMappingHandlerMapping();
        requestMappingHandlerMapping.setUseSuffixPatternMatch(false);
        requestMappingHandlerMapping.setUseTrailingSlashMatch(false);
        return requestMappingHandlerMapping;
    }

    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(BASE_MESSAGE_SOURCE, String.format(MESSAGE_SOURCE, resourceContext()));
        messageSource.setCacheSeconds(5);
        return messageSource;
    }
    @Override
    public Validator getValidator(){
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource());
        return validator;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(BASE_RESOURCE_HANDLER, String.format(RESOURCE_HANDLER, resourceContext()))
                .addResourceLocations(BASE_RESOURCE_LOCATION, String.format(RESOURCE_LOCATION, resourceContext()))
                .setCachePeriod(3600);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer config){
        config.enable();
    }
}
