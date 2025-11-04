package com.erickWck.edge_service.web;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthTokenPropagator implements GlobalFilter {

    /**
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("booking", r -> r.path("/api/bookings/**")
                        .filters(f -> f.filter((exchange, chain) -> {
                            var token = exchange.getRequest().getHeaders().getFirst("Authorization");
                            if (token != null) {
                                return chain.filter(
                                        exchange.mutate()
                                                .request(rq -> rq.headers(headers -> headers.set("Authorization", token)))
                                                .build()
                                );
                            }
                            return chain.filter(exchange);
                        }))
                        .uri("http://booking-service"))
                .build();
    }
**/
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
