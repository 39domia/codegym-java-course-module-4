package com.config;

import com.controller.CustomerController;
import com.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.controller", "com.service"})
public class ApplicationConfig extends WebMvcConfigurerAdapter {
    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/customers/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
