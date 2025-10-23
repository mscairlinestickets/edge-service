package com.erickWck.edge_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@EnableWebFlux
public class SecurityConfig {


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http
                .authorizeExchange(exchange -> {
                    exchange.pathMatchers("/actuator").permitAll()
                            .pathMatchers("/login","/css/**","/js/**").permitAll()
                            .anyExchange().authenticated();
                })
                .oauth2Login(oauth2 -> oauth2.loginPage("/login"))
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .build();

    }


}
