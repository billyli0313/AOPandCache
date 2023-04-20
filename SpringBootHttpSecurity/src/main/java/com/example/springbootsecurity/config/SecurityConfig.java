package com.example.springbootsecurity.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@org.springframework.context.annotation.Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin();

        http.authorizeRequests()
                .antMatchers("/club/**").permitAll() // allow all people can read the data - no need to signin the form
                .antMatchers("/**").hasRole("manager")
         .anyRequest().authenticated()
         .and().csrf().disable();
    }

    // Authorization
    // Authentication
}
