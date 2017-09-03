package io.logregator.config;

import java.util.List;

public final class LogregatorConfigBuilder {
    private List<Config> configs;

    private LogregatorConfigBuilder() {
    }

    public static LogregatorConfigBuilder aLogregatorConfig() {
        return new LogregatorConfigBuilder();
    }

    public LogregatorConfigBuilder withConfigs(List<Config> configs) {
        this.configs = configs;
        return this;
    }

    public LogregatorConfig build() {
        LogregatorConfig logregatorConfig = new LogregatorConfig();
        logregatorConfig.setConfigs(configs);
        return logregatorConfig;
    }
}
