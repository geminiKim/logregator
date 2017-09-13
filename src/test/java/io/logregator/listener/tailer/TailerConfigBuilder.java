package io.logregator.listener.tailer;

public final class TailerConfigBuilder {
    private String path;

    private TailerConfigBuilder() {
    }

    public static TailerConfigBuilder aTailerConfig() {
        return new TailerConfigBuilder();
    }

    public TailerConfigBuilder withPath(String path) {
        this.path = path;
        return this;
    }

    public TailerConfig build() {
        TailerConfig tailerConfig = new TailerConfig();
        tailerConfig.setPath(path);
        return tailerConfig;
    }
}
