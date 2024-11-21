package org.nda.osp.routers;

import org.nda.osp.handlers.CommonGetHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class RoutersConfiguration {

    @Bean("commonGetRouter")
    public RouterFunction<ServerResponse> commonGetRouter(CommonGetHandler commonGetHandler) {
        return RouterFunctions.route(GET("/get/route"), commonGetHandler);
    }

}
