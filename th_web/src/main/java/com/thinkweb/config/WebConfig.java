package com.thinkweb.config;

import com.thinkweb.common.VelocityToolbox2View;
import org.apache.commons.collections.ExtendedProperties;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.velocity.VelocityConfig;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.dialect.SpringStandardDialect;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

import java.io.IOException;

/**
 * Created by juepei on 2015/9/25.
 */

@Configuration
@ComponentScan("com.thinkweb.controller")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(31556926);
    }

//    ====================== velocity config ============================
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        VelocityLayoutViewResolver viewResolver = new VelocityLayoutViewResolver();
//        viewResolver.setCache(false);
//        viewResolver.setLayoutUrl("/layout/main.vm");
//        viewResolver.setPrefix("/template/");
//        viewResolver.setSuffix(".vm");
//        viewResolver.setExposeSpringMacroHelpers(true);
//        viewResolver.setContentType("text/html;charset=UTF-8");
//        viewResolver.setScreenContentKey("screen");
//        viewResolver.setRequestContextAttribute("context");
//        viewResolver.setExposeRequestAttributes(true);
//        viewResolver.setToolboxConfigLocation("/WEB-INF/velocity/toolbox.xml");
//        viewResolver.setDateToolAttribute("dateTool");
//        viewResolver.setViewClass(VelocityToolbox2View.class);
//        registry.viewResolver(viewResolver);
//    }
//
//    @Bean
//    public VelocityConfigurer velocityConfigurer() {
//        VelocityConfigurer config = new VelocityConfigurer();
//        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
//        config.setConfigLocation(resourceLoader.getResource("velocity.properties"));
//        return config;
//    }
//    ==================== velocity config end =============================

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

//    =========================  thymeleaf config =============
    @Bean
    public ViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(1);
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    @Bean
    public UrlTemplateResolver urlTemplateResolver(){
        return new UrlTemplateResolver();
    }

    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(templateResolver());
        templateEngine.addTemplateResolver(urlTemplateResolver());
        return templateEngine;
    }

    @Bean
    public TemplateResolver templateResolver(){
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/thymeleaf/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCacheable(false);
        return templateResolver;
    }
//    ==================== thymeleaf end ===================


// ====================== JSP Config =====================
//    @Bean
//    public UrlBasedViewResolver setupViewResolver(){
//        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//        resolver.setPrefix("/WEB-INF/jsp/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
//        return resolver;
//    }


//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("login");
//    }
//    =================== JSP end ==========================
}
