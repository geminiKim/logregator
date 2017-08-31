package io.logregator.config;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigLoader {
    private final ObjectMapper mapper;

    public ConfigLoader(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public static Config load() {
        return new Config();
    }
}
