package org.nda.osp.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RoutersConfiguration {

    @Bean
    public RouterFunction<ServerResponse> commonGetRouter() {
        return RouterFunctions.route(GET("/get/route"), req->ok().bodyValue("X"));
    }


}
