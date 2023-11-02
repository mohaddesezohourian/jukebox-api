package com.example.jukebox.service;

import com.example.jukebox.configuration.AppConfig;
import com.example.jukebox.model.Jukebox;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JukeService {

    HttpRequestService httpRequestService;
    AppConfig appConfig;

    public List<Jukebox> getAllJukes() {
        String stringResponse = httpRequestService.getRequest(appConfig.getJukeboxUri());
        return stringToListOfObject(stringResponse);
    }

    private List<Jukebox> stringToListOfObject(String string) {
        Gson gson = new Gson();
        Type typeOfList = new TypeToken<ArrayList<Jukebox>>() {
        }.getType();
        return gson.fromJson(string, typeOfList);
    }
}
