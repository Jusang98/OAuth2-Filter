package com.nhnacademy.jdbc.board.config;


import com.mysql.cj.jdbc.Driver;
import com.nhnacademy.jdbc.board.Base;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootConfig {
    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(Driver.class.getName());
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/DBApp2");
        basicDataSource.setUsername("****");
        basicDataSource.setPassword("****");

        basicDataSource.setInitialSize(10);
        basicDataSource.setMaxTotal(10);
        basicDataSource.setMinIdle(10);
        basicDataSource.setMaxIdle(10);

        basicDataSource.setMaxWaitMillis(1000);

        basicDataSource.setTestOnBorrow(true);
        basicDataSource.setTestOnReturn(true);
        basicDataSource.setTestWhileIdle(true);
        return basicDataSource;
    }
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasename("message");

        return messageSource;
    }

}
