package io.logregator.config;

import io.logregator.config.component.ComponentConfig;
import io.logregator.config.component.ComponentType;

public final class ConfigBuilder {
    private ComponentConfig listener = buildDefaultConfigDetail();
    private ComponentConfig sender = buildDefaultConfigDetail();

    private ConfigBuilder() {
    }

    private ComponentConfig buildDefaultConfigDetail() {
        ComponentConfig detail = new ComponentConfig(ComponentType.http);
        return detail;
    }

    public static ConfigBuilder aConfig() {
        return new ConfigBuilder();
    }

    public ConfigBuilder withListener(ComponentConfig listener) {
        this.listener = listener;
        return this;
    }

    public ConfigBuilder withSender(ComponentConfig sender) {
        this.sender = sender;
        return this;
    }

    public Config build() {
        Config config = new Config();
        config.setListener(listener);
        config.setSender(sender);
        return config;
    }
}
