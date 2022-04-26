package com.addamsestates.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/propertiesforsale","/propertiesforsale2","/propertiestolet","/viewProperty","/addEnquiry","/contactUs","/**/*.jpg","/**/*.png").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }
}
