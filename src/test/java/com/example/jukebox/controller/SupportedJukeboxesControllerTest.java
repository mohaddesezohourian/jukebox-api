package com.example.jukebox.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest

public class SupportedJukeboxesControllerTest {

    @Autowired
    private SupportedJukeboxesController supportedJukeboxesController;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(supportedJukeboxesController);
    }

    @Test
    void checkValidSettingId(){
        Assertions.assertNotNull(supportedJukeboxesController.getSupportedJukeboxes("358a044e-decc-47cc-aaf1-e2253a00998",null,null,null));
    }

    @Test
    void checkValidSettingIdAndModel(){
        Assertions.assertNotNull(supportedJukeboxesController.getSupportedJukeboxes("358a044e-decc-47cc-aaf1-e2253a00998","angelina",null,null));
    }

    @Test
    void checkValidSettingIdAndModelWithOffsetAndLimit(){
        ResponseEntity<List<String>> response = supportedJukeboxesController.getSupportedJukeboxes("358a044e-decc-47cc-aaf1-e2253a00998","angelina",1,2);
        Assertions.assertEquals(1, response.getBody().size());
    }


    @Test
    void checkInvalidSettingId(){
        ResponseEntity<List<String>> response = supportedJukeboxesController.getSupportedJukeboxes("invalid id","angelina",1,2);
        Assertions.assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

}
