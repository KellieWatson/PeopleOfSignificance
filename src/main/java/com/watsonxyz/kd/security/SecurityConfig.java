package com.watsonxyz.kd.security;

import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;
import com.watsonxyz.kd.LoginView;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends VaadinWebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        super.configure(httpSecurity);
        setLoginView(httpSecurity, LoginView.class);
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception{
        webSecurity.ignoring().antMatchers("/images/**");
        super.configure(webSecurity);
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(User.withUsername("user")
                .password("{noop}userpass")
                .roles("USER")
                .build());
    }

}
