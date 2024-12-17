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

import java.net.http.HttpResponse;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CommonGetHandler implements HandlerFunction<ServerResponse> {

    private final Marshaller marshaller;

    @SneakyThrows
    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        HttpResponse<byte[]> future = marshaller.callBack();
        return ServerResponse.ok().bodyValue(future.body());
    }

}