package io.logregator.listener.http;

public final class HttpServerConfigBuilder {
    private String uri;
    private int port;

    private HttpServerConfigBuilder() {
    }

    public static HttpServerConfigBuilder aHttpServerConfig() {
        return new HttpServerConfigBuilder();
    }

    public HttpServerConfigBuilder withUri(String uri) {
        this.uri = uri;
        return this;
    }

    public HttpServerConfigBuilder withPort(int port) {
        this.port = port;
        return this;
    }

    public HttpServerConfig build() {
        HttpServerConfig httpServerConfig = new HttpServerConfig();
        httpServerConfig.setUri(uri);
        httpServerConfig.setPort(port);
        return httpServerConfig;
    }
}
