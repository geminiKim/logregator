package io.logregator.collector.tailer;

public final class TailCollectorConfigBuilder {
    private String path;

    private TailCollectorConfigBuilder() {
    }

    public static TailCollectorConfigBuilder builder() {
        return new TailCollectorConfigBuilder();
    }

    public TailCollectorConfigBuilder withPath(String path) {
        this.path = path;
        return this;
    }

    public TailCollectorConfig build() {
        TailCollectorConfig tailCollectorConfig = new TailCollectorConfig();
        tailCollectorConfig.setPath(path);
        return tailCollectorConfig;
    }
}
