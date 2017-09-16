package io.logregator.config;

import com.google.common.collect.Maps;

import java.util.Map;

public final class ConfigBuilder {
    private ComponentType type = ComponentType.http;
    private Map<String, Object> config = Maps.newHashMap();

    private ConfigBuilder() {
    }

    public static ConfigBuilder aConfigDetail() {
        return new ConfigBuilder();
    }

    public ConfigBuilder withType(ComponentType type) {
        this.type = type;
        return this;
    }

    public ConfigBuilder withConfig(Map<String, Object> config) {
        this.config = config;
        return this;
    }

    public Config build() {
        Config config = new Config(type);
        config.setConfig(this.config);
        return config;
    }
}
