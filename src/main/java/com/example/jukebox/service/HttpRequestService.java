package com.example.jukebox.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class HttpRequestService {

    private WebClient webClient;

    public String getRequest(String uri) {

        Mono<String> rawResponse = webClient
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class);

        return rawResponse.block();

    }

}
