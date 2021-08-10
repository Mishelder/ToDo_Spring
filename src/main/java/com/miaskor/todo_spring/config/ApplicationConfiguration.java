package com.miaskor.todo_spring.config;

import com.miaskor.todo_spring.filter.MainFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    //Redundant, but if you wanna set particular URL, must used this bean
    /*@Bean
    public FilterRegistrationBean<MainFilter> filterRegistrationBean(){
        FilterRegistrationBean<MainFilter> filterBean = new FilterRegistrationBean<>();
        filterBean.setFilter(new MainFilter());
        filterBean.addUrlPatterns("*");
        return filterBean;
    }*/
}
