package com.dsecet.core.cfg;

import com.dsecet.ApplicationConfig;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = ApplicationConfig.class)
public class JpaConfig implements TransactionManagementConfigurer{

    @Value("${dataSource.driverClassName}")
    private String driver;

    @Value("${dataSource.url}")
    private String url;

    @Value("${dataSource.username}")
    private String username;

    @Value("${dataSource.password}")
    private String password;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;

    @Value("${hibernate.show.sql}")
    private boolean showSQL;

    @Value("${hibernate.format.sql}")
    private boolean formatSQL;

    @Value("${hibernate.generate.statistics}")
    private boolean generateStatistics;

    @Value("${hibernate.max.fetch.depth}")
    private int maxFetchDepth;

    @Value("${hibernate.jdbc.batch.size}")
    private int jdbcBatchSize;

    @Value("${hibernate.jdbc.fetch.size}")
    private int jdbcFetchSize;

    @Value("${hibernate.naming.strategy}")
    private String namingStrategy;

    @Value("${hibernate.cache.use.second.level.cache}")
    private boolean enableSecondLevelCache;

    @Value("${connection.use.unicode}")
    private boolean useUnicode;

    @Value("${connection.character.encoding}")
    private String connectionEncoding;

    @Value("${db.pool.initial.size}")
    private int poolInitialSize;

    @Value("${db.pool.max.active}")
    private int poolMaxActive;

    @Value("${db.pool.max.idle}")
    private int poolMaxIdle;

    @Value("${db.pool.min.idle}")
    private int poolMinIdle;

    @Value("${db.pool.max.wait}")
    private int poolMaxWait;

    @Value("${db.pool.log.abandoned}")
    private boolean poolLogAbandoned;

    @Value("${db.pool.remove.abandoned}")
    private boolean poolRemoveAbandoned;

    @Value("${db.pool.remove.abandoned.timeout}")
    private int poolRemoveAbandonedTimeout;

    @Value("${db.pool.default.autocommit}")
    private boolean poolDefaultAutocommit;

    @Bean(destroyMethod = "close")
    public DataSource configureDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(poolInitialSize);
        dataSource.setMaxActive(poolMaxActive);
        dataSource.setMaxIdle(poolMaxIdle);
        dataSource.setMinIdle(poolMinIdle);
        dataSource.setMaxWait(poolMaxWait);
        dataSource.setLogAbandoned(poolLogAbandoned);
        dataSource.setRemoveAbandoned(poolRemoveAbandoned);
        dataSource.setRemoveAbandonedTimeout(poolRemoveAbandonedTimeout);
        dataSource.setDefaultAutoCommit(poolDefaultAutocommit);
        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean configureEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(configureDataSource());
        entityManagerFactoryBean.setPackagesToScan("com.dsecet.core.domain");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put(Environment.DIALECT, dialect);
        jpaProperties.put(Environment.HBM2DDL_AUTO, hbm2ddlAuto);
        jpaProperties.put(Environment.SHOW_SQL, showSQL);
        jpaProperties.put(Environment.FORMAT_SQL, formatSQL);
        jpaProperties.put(Environment.GENERATE_STATISTICS, generateStatistics);
        jpaProperties.put(Environment.MAX_FETCH_DEPTH, maxFetchDepth);
        jpaProperties.put(Environment.STATEMENT_FETCH_SIZE, jdbcFetchSize);
        jpaProperties.put(Environment.STATEMENT_BATCH_SIZE, jdbcBatchSize);
        jpaProperties.put(Environment.USE_SECOND_LEVEL_CACHE, enableSecondLevelCache);

        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean;
    }

    @Bean(name="transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager(){
        return new JpaTransactionManager();
    }

}
