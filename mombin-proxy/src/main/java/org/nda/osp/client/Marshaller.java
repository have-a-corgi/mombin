package org.nda.osp.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class Marshaller {

    private final WebClient webClient;

    public Mono<byte[]> get() {
        return webClient
                .get()
                .uri("https://www.gazeta.ru")
                .retrieve()
                .bodyToMono(byte[].class);
    }


}
