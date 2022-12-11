package com.example.oliveira.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        ((ExpressionUrlAuthorizationConfigurer.
                AuthorizedUrl)http.
                authorizeRequests().
                anyRequest()).
                authenticated().
                and();
        http.formLogin();
        http.httpBasic();
        return (SecurityFilterChain)http.build();
    }

}
