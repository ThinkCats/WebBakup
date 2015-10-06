package com.thinkcat.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * Created by Think Cat on 15/10/4.
 */

@Configuration
@PropertySource("classpath:${env}-config.properties")
public class ProperConfig implements EnvironmentAware {

    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }
}