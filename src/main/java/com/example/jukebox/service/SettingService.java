package com.example.jukebox.service;

import com.example.jukebox.configuration.AppConfig;
import com.example.jukebox.model.Setting;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SettingService {

    HttpRequestService httpRequestService;
    AppConfig appConfig;

    public List<Setting> getAllSettings() throws JSONException {
        String stringResponse = httpRequestService.getRequest(appConfig.getSettingUri());
        JSONObject jsonResponse = new JSONObject(stringResponse);
        return stringToListOfObject(jsonResponse.getJSONArray("settings").toString());
    }

    private List<Setting> stringToListOfObject(String string) {
        Gson gson = new Gson();
        Type typeOfList = new TypeToken<ArrayList<Setting>>() {
        }.getType();
        return gson.fromJson(string, typeOfList);
    }
}
