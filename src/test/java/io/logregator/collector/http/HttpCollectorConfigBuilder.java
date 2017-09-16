package io.logregator.collector.http;

public final class HttpCollectorConfigBuilder {
    private String uri;
    private int port;

    private HttpCollectorConfigBuilder() {
    }

    public static HttpCollectorConfigBuilder builder() {
        return new HttpCollectorConfigBuilder();
    }

    public HttpCollectorConfigBuilder withUri(String uri) {
        this.uri = uri;
        return this;
    }

    public HttpCollectorConfigBuilder withPort(int port) {
        this.port = port;
        return this;
    }

    public HttpCollectorConfig build() {
        HttpCollectorConfig httpCollectorConfig = new HttpCollectorConfig();
        httpCollectorConfig.setUri(uri);
        httpCollectorConfig.setPort(port);
        return httpCollectorConfig;
    }
}
