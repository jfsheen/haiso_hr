package com.haiso.hr.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.util.Properties;
//import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Created by ff on 4/30/14.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.haiso.hr.dao")
public class SpringDataConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;

    @Value("jdbc.driverClassName")
    private String dc;

    // Declare a datasource that has pooling capabilities
    @Bean
    public DataSource dataSource() {
        try {
            /* dbcp datasource*/
            BasicDataSource ds = new BasicDataSource();
            ds.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
            ds.setUsername(env.getRequiredProperty("jdbc.username"));
            ds.setPassword(env.getRequiredProperty("jdbc.password"));
            ds.setUrl(env.getRequiredProperty("jdbc.url"));
            return ds;

        /* c3p0 datasource
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(env.getRequiredProperty("app.jdbc.driverClassName"));
            ds.setJdbcUrl(env.getRequiredProperty("app.jdbc.url"));
            ds.setUser(env.getRequiredProperty("app.jdbc.username"));
            ds.setPassword(env.getRequiredProperty("app.jdbc.password"));
            ds.setAcquireIncrement(5);
            ds.setIdleConnectionTestPeriod(60);
            ds.setMaxPoolSize(100);
            ds.setMaxStatements(50);
            ds.setMinPoolSize(10);
            return ds;*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Declare a JPA entityManagerFactory
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan("com.haiso.hr.entity");
        em.setDataSource(dataSource());
        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        vendor.setShowSql(false);
        vendor.setDatabase(Database.MYSQL);
        vendor.setGenerateDdl(true);
        em.setJpaVendorAdapter(vendor);
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.validator.apply_to_ddl", "true");
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        jpaProperties.setProperty("hibernate.format_sql", "true");
        em.setJpaProperties(jpaProperties);
        return em;
    }

    // Declare a transaction manager
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        transactionManager.setJpaDialect(new HibernateJpaDialect());
        return transactionManager;
    }

}
