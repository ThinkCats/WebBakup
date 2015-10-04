package com.thinkcat.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Think Cat on 15/10/4.
 */
@Configuration
@MapperScan("com.thinkcat.presistence")
public class DataConfig {

    @Configuration
    public static class DataSourceConfig{

        @Value("jdbc.url")
        String url;
        @Value("jdbc.username")
        String username;
        @Value("jdbc.password")
        String password;
        @Value("jdbc.driver.name")
        String driverName;
        @Value("${jdbc.initsize}")
        int initSize;
        @Value("${jdbc.datasource.maxWait}")
        int maxWait;
        @Value("${jdbc.datasource.maxIdle}")
        int maxIdle;
        @Value("${jdbc.datasource.minIdle}")
        int minIdle;
        @Value("${jdbc.datasource.removeAbandonedTimeout}")
        int removeAbandonedTimeout;
        @Value("jdbc.datasource.properties")
        String property;

        @Bean
        public DataSource dataSource(){
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setDriverClassName(driverName);
            dataSource.setInitialSize(initSize);
            dataSource.setMaxWaitMillis(maxWait);
            dataSource.setMaxIdle(maxIdle);
            dataSource.setMinIdle(minIdle);
            dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
            dataSource.setConnectionProperties(property);
            return dataSource;
        }

        @Bean
        public DataSourceTransactionManager transactionManager(){
            return new DataSourceTransactionManager(dataSource());
        }

        @Bean
        public SqlSessionFactoryBean factoryBean(){
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource());
            factoryBean.setTypeAliasesPackage("com.thinkcat.domain");
            return factoryBean;
        }
    }

}
