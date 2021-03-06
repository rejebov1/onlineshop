package org.myproject.repository.dao.hibernateConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = {"org.myproject.repository.dao","org.myproject.service"})
public class HibernateConfig {

    @Autowired
    private  Environment environment;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        Properties properties = new Properties();

        properties.put(DRIVER, environment.getProperty("postgresql.driver"));
        properties.put(URL, environment.getProperty("postgresql.jdbcUrl"));
        properties.put(USER, environment.getProperty("postgresql.username"));
        properties.put(PASS, environment.getProperty("postgresql.password"));

        properties.put(SHOW_SQL, environment.getProperty("hibernate.show_sql"));
        properties.put(FORMAT_SQL, environment.getProperty("hibernate.format_sql"));
        properties.put(USE_SQL_COMMENTS, environment.getProperty("hibernate.use_sql_comments"));
        //todo schema validation fix
        //properties.put(HBM2DDL_AUTO, environment.getProperty("hibernate.hbm2ddl.auto"));

        properties.put(C3P0_MIN_SIZE, environment.getProperty("hibernate.c3p0.min_size"));
        properties.put(C3P0_MAX_SIZE, environment.getProperty("hibernate.c3p0.max_size"));
        properties.put(C3P0_ACQUIRE_INCREMENT, environment.getProperty("hibernate.c3p0.acquire_increment"));
        properties.put(C3P0_TIMEOUT, environment.getProperty("hibernate.c3p0.timeout"));
        properties.put(C3P0_MAX_STATEMENTS, environment.getProperty("hibernate.c3p0.max_statements"));

        factoryBean.setHibernateProperties(properties);
        factoryBean.setPackagesToScan("org.myproject.repository.entity");

        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

}