package com.thinkweb.config;

import com.thinkcat.config.DataConfig;
import com.thinkcat.config.ProperConfig;
import com.thinkcat.config.ServiceConfig;
import com.thinkweb.security.CustomerFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created by juepei on 2015/9/25.
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                SecurityConfig.class,
                ProperConfig.class,
                DataConfig.class,
                ServiceConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected Filter[] getServletFilters() {
       // CustomerFilter filter = new CustomerFilter();
        return new Filter[]{};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
