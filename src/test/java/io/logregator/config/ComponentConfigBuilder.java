package io.logregator.config;

import com.google.common.collect.Maps;
import io.logregator.config.component.ComponentConfig;
import io.logregator.config.component.ComponentType;

import java.util.Map;

public final class ComponentConfigBuilder {
    private ComponentType type = ComponentType.http;
    private Map<String, Object> config = Maps.newHashMap();

    private ComponentConfigBuilder() {
    }

    public static ComponentConfigBuilder aConfigDetail() {
        return new ComponentConfigBuilder();
    }

    public ComponentConfigBuilder withType(ComponentType type) {
        this.type = type;
        return this;
    }

    public ComponentConfigBuilder withConfig(Map<String, Object> config) {
        this.config = config;
        return this;
    }

    public ComponentConfig build() {
        ComponentConfig componentConfig = new ComponentConfig(type);
        componentConfig.setConfig(config);
        return componentConfig;
    }
}