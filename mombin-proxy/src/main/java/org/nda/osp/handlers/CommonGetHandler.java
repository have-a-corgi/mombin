package org.nda.osp.handlers;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.nda.osp.client.Marshaller;

import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CommonGetHandler implements HandlerFunction<ServerResponse> {

    private final Marshaller marshaller;

    @SneakyThrows
    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        return Mono.just(marshaller.callBack()).publishOn(Schedulers.boundedElastic())
                .map(httpResponse -> {
                    System.out.println("THREAD Y: "+Thread.currentThread().getName());
                    return ServerResponse.ok().bodyValue(httpResponse.body()).block();
                });
    }

}