package io.logregator.config;

import com.google.common.collect.Maps;

import java.util.Map;

public final class ConfigDetailBuilder {
    private ComponentType type = ComponentType.http;
    private Map<String, Object> config = Maps.newHashMap();

    private ConfigDetailBuilder() {
    }

    public static ConfigDetailBuilder aConfigDetail() {
        return new ConfigDetailBuilder();
    }

    public ConfigDetailBuilder withType(ComponentType type) {
        this.type = type;
        return this;
    }

    public ConfigDetailBuilder withConfig(Map<String, Object> config) {
        this.config = config;
        return this;
    }

    public ConfigDetail build() {
        ConfigDetail configDetail = new ConfigDetail(type);
        configDetail.setConfig(config);
        return configDetail;
    }
}
