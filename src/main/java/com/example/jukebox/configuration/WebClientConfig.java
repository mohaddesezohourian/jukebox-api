package com.example.jukebox.configuration;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class WebClientConfig {
    AppConfig appConfig;

    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .baseUrl(appConfig.getBaseUrl())
                .build();
    }

}
