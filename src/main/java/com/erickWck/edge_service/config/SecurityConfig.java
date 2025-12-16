package com.erickWck.edge_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;


@Configuration
public class SecurityConfig {


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .cors(ServerHttpSecurity.CorsSpec::disable)
                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
                .authorizeExchange(exchange -> {
                    exchange.pathMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                            .pathMatchers(HttpMethod.POST, "/bookings").permitAll()
                            .pathMatchers(HttpMethod.GET, "/api/auth/.well-known/jwks.json", "/api/flights/**").permitAll()
                            .pathMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                            .anyExchange().authenticated();
                })
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

        return http.build();

    }


}
