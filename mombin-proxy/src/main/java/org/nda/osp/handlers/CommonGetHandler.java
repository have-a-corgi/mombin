package org.nda.osp.handlers;

import lombok.extern.slf4j.Slf4j;
import org.nda.osp.dto.ResponseDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Controller
public class CommonGetHandler implements HandlerFunction<ServerResponse> {

    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        String path = request.uri().getPath();
        log.warn("Path {}", path);
        return ok().contentType(MediaType.APPLICATION_JSON).bodyValue(new ResponseDto(path));
    }
}
