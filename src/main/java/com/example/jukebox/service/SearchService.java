package com.example.jukebox.service;

import com.example.jukebox.exception.ErrorResponse;
import com.example.jukebox.exception.GeneralErrorException;
import com.example.jukebox.model.Jukebox;
import com.example.jukebox.model.Setting;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchService {

    final SettingService settingService;
    final JukeService jukeService;
    List<Setting> allSettings;
    List<Jukebox> allJukes;

    public SearchService(SettingService settingService, JukeService jukeService) {
        this.settingService = settingService;
        this.jukeService = jukeService;
    }


    public List<String> matchJukeboxes(String settingId, String model) throws GeneralErrorException {
        try {
            getData();
        } catch (JSONException e) {
            e.printStackTrace();
            throw new GeneralErrorException(ErrorResponse.ServiceUnavailable);
        }
        if (allSettings == null || allJukes == null) throw new GeneralErrorException(ErrorResponse.ServiceUnavailable);
        Setting requireSetting = findSettingById(settingId);
        if (requireSetting == null) throw new GeneralErrorException(ErrorResponse.ItemNotFound);
        List<Jukebox> filteredjukes = (model == null) ? allJukes : filterJukesByModel(model);
        filteredjukes = findJukeByRequiredSetting(requireSetting, filteredjukes);

        return filteredjukes
                .stream()
                .map(Jukebox::getId)
                .collect(Collectors.toList());
    }

    private void getData() throws JSONException {
        this.allSettings = settingService.getAllSettings();
        this.allJukes = jukeService.getAllJukes();
    }

    private List<Jukebox> filterJukesByModel(String model) {
        return allJukes
                .stream()
                .filter(juke -> model.equals(juke.getModel()))
                .collect(Collectors.toList());
    }

    private List<Jukebox> findJukeByRequiredSetting(Setting requireSetting, List<Jukebox> filteredjukes) {
        for (String requirement : requireSetting.getRequires()
        ) {
            filteredjukes = filterListByRequiredComponent(requirement, filteredjukes);
        }
        return filteredjukes;
    }

    private Setting findSettingById(String id) {
        return allSettings
                .stream()
                .filter(setting -> id.equals(setting.getId()))
                .findAny()
                .orElse(null); //throw exception
    }

    private List<Jukebox> filterListByRequiredComponent(String component, List<Jukebox> jukes) {
        return jukes
                .stream()
                .filter(jukebox -> containComponentInJuke(jukebox, component))
                .collect(Collectors.toList());
    }

    private boolean containComponentInJuke(Jukebox juke, String requireComponent) {
        for (Map<String, String> existingComponent : juke.getComponents()
        ) {
            if (requireComponent.equals(existingComponent.get("name"))) return true;
        }
        return false;
    }
}

