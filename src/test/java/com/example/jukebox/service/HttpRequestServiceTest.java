package com.example.jukebox.service;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
public class HttpRequestServiceTest {

    @Test
    public void getRequest_returnOkHttpStatus(){
        WebClient webClient=WebClient.builder().baseUrl("http://my-json-server.typicode.com").build();
        HttpRequestService httpRequestService=new HttpRequestService(webClient);
        String settingResponse=httpRequestService.getRequest("touchtunes/tech-assignment/settings");
        String jukeResponse=httpRequestService.getRequest("touchtunes/tech-assignment/jukes");
        Assertions.assertNotNull(settingResponse);
        Assertions.assertNotNull(jukeResponse);
    }
}
