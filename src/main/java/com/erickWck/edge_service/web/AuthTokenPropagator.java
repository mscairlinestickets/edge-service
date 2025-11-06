package com.erickWck.edge_service.web;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthTokenPropagator implements GlobalFilter {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        var token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (token != null) {
            exchange = exchange.mutate()
                    .request(rq -> rq.headers(headers -> headers.set("Authorization", token)))
                    .build();
        }
        return chain.filter(exchange);
    }
}
