package com.example.jukebox.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Jukebox {
    String id;
    String model;
    List<Map<String, String>> components;
}
