package com.erickWck.edge_service.web;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

@Configuration
public class RateLimiterConfig {

    @Bean
    public KeyResolver keyResolver() {
        return exchange -> exchange.getPrincipal()
                .cast(JwtAuthenticationToken.class)
                .map(auth -> auth.getToken().getClaimAsString("username"))
                .defaultIfEmpty("anonymous");
    }

    /**
     *
     * @return chave unica por usuario autenticado pelo username
     * @Bean
     *     public KeyResolver keyResolver() {
     *         return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
     *     }
     *
     */


}
