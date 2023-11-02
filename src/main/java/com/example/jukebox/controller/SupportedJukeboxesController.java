package com.example.jukebox.controller;

import com.example.jukebox.exception.GeneralErrorException;
import com.example.jukebox.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/juke")
@AllArgsConstructor
public class SupportedJukeboxesController {

    SearchService searchService;


    @GetMapping("/search/by-setting")
    public ResponseEntity<List<String>> getSupportedJukeboxes(@RequestParam String settingId,
                                                              @RequestParam(required = false) String model,
                                                              @RequestParam(required = false, defaultValue = "0") Integer offset,
                                                              @RequestParam(required = false) Integer limit) {

        List<String> supportedJukeboxes = null;
        try {
            supportedJukeboxes = searchService.matchJukeboxes(settingId, model);
        } catch (GeneralErrorException e) {
            e.printStackTrace();
            return ResponseEntity.status(e.getErrorResponse().getCode()).body(List.of(e.getErrorResponse().getMessage()));
        }
        limit = (limit == null || (limit + offset) >= supportedJukeboxes.size()) ? supportedJukeboxes.size() : limit;
        return ResponseEntity.ok(supportedJukeboxes.subList(offset, limit));


    }
}
