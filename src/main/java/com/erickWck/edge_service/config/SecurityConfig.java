package com.erickWck.edge_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
                            .pathMatchers(HttpMethod.GET, "/api/flights/**").permitAll()
                            .anyExchange().authenticated();
                }).build();

    }


}
