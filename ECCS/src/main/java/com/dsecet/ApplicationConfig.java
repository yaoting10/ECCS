package com.dsecet;

import com.dsecet.core.cfg.JpaConfig;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

import static org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScan(basePackageClasses = ApplicationConfig.class, excludeFilters = @Filter({Controller.class, Configuration.class}))
@Import(JpaConfig.class)
@Slf4j
public class ApplicationConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PlatformTransactionManager transactionManager;

	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() throws IOException {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocations(Lists
				.newArrayList(
                        new ClassPathResource("/persistence.properties"),
						new ClassPathResource("/mail.properties"),
                        new ClassPathResource("/system.properties")
                        ).stream()
				.toArray(Resource[]::new));
		return ppc;
	}

    @Bean
    public static Properties sysProperties() throws IOException {
        return PropertiesLoaderUtils.loadProperties(new ClassPathResource("/system.properties"));
    }

  /*  @Bean
    public MultipartResolver filterMultipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        try {
            Properties sysProperties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("/system.properties"));
            commonsMultipartResolver.setUploadTempDir(new FileSystemResource(sysProperties.getProperty("upload.tmp.dir")));
        } catch (Exception e) {
        }
        return commonsMultipartResolver;
    }*/

  /*  @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws Exception {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(new SpringBeanJobFactory());
        schedulerFactoryBean.setDataSource(dataSource);
        schedulerFactoryBean.setTransactionManager(transactionManager);
        return schedulerFactoryBean;
    }*/
}