package org.nda.osp.handlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nda.osp.client.Marshaller;
import org.nda.osp.dto.ResponseDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CommonGetHandler implements HandlerFunction<ServerResponse> {

    private final Marshaller marshaller;

    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        Mono<byte[]> response = marshaller.get();
        return ServerResponse.ok().body(response, byte[].class);
    }
}
