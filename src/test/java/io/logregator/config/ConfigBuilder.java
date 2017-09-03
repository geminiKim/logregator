package io.logregator.config;

public final class ConfigBuilder {
    private ConfigDetail listener = buildDefaultConfigDetail();
    private ConfigDetail sender = buildDefaultConfigDetail();

    private ConfigBuilder() {
    }

    private ConfigDetail buildDefaultConfigDetail() {
        ConfigDetail detail = new ConfigDetail(ComponentType.http);
        return detail;
    }

    public static ConfigBuilder aConfig() {
        return new ConfigBuilder();
    }

    public ConfigBuilder withListener(ConfigDetail listener) {
        this.listener = listener;
        return this;
    }

    public ConfigBuilder withSender(ConfigDetail sender) {
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
