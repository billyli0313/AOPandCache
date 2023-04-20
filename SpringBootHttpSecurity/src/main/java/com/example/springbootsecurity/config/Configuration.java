package com.example.springbootsecurity.config;

import com.example.springbootsecurity.filter.PubFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;


import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

@org.springframework.context.annotation.Configuration
public class Configuration {


//    Have filter class first
//    and then add method for how to filter
//    In filter bean, set pattern to add the controller’s path

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        List<String> patterns = new ArrayList<>();
        patterns.add("/club");
        filterRegistrationBean.setUrlPatterns(patterns);
        filterRegistrationBean.setFilter(new PubFilter());
        return filterRegistrationBean;
    }

}
