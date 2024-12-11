package org.nda.osp.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Service
public class Marshaller {

    private final WebClient webClient;

    public byte[] callBack() {
        return webClient
                .get()
                .uri("https://www.gazeta.ru")
                .exchangeToMono(cr ->
                        cr.bodyToMono(byte[].class)).block();
    }
}
