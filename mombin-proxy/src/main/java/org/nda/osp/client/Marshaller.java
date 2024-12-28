package org.nda.osp.client;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@RequiredArgsConstructor
@Service
public class Marshaller {

    private final WebClient webClient;

    @SneakyThrows
    public HttpResponse<byte[]> callBack(ServerRequest serverRequest) {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create("http://localhost:8091/imitation"))
                .GET().build();
        return client.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());
    }
}
