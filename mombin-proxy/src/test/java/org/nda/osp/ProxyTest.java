package org.nda.osp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


@SpringBootTest
public class ProxyTest {

    @Autowired
    @Qualifier("commonGetRouter")
    private RouterFunction<ServerResponse> commonGetRouter;

    @Test
    public void commonGetHandlerTest() {
        String expectedResponse = """
                {"name":"test"}""";
        WebTestClient client = WebTestClient
                .bindToRouterFunction(commonGetRouter)
                .build();
        client.get().uri("/get/route")
                .exchange().expectStatus().isOk()
                .expectBody().json(expectedResponse);
    }

}
