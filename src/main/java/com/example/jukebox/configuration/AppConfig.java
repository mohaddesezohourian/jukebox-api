package com.example.jukebox.configuration;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "config")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppConfig {
    String baseUrl;
    String jukeboxUri;
    String settingUri;
}
