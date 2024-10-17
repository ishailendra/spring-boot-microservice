package dev.techsphere.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class YummyCallsGatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(YummyCallsGatewayApp.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-route", r -> r.path("/order/**")
                        .filters(f -> f.rewritePath("/order/(?<segment>.*)", "/${segment}"))
                        .uri("lb://yummy-calls-order"))
                .route("restaurant-route", r -> r.path("/restaurant/**")
                        .filters(f -> f.rewritePath("/restaurant/(?<segment>.*)", "/${segment}"))
                        .uri("lb://yummy-calls-restaurant"))
                .route("user-route", r -> r.path("/user/**")
                        .filters(f -> f.rewritePath("/user/(?<segment>.*)", "/${segment}"))
                        .uri("lb://yummy-calls-user"))
                .build();
    }
}

