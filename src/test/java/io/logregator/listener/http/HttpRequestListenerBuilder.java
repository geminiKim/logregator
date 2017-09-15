package io.logregator.listener.http;

import io.logregator.sender.Sender;

public final class HttpRequestListenerBuilder {
    private HttpServerConfig config = HttpServerConfigBuilder.aHttpServerConfig().build();
    private Sender sender;

    private HttpRequestListenerBuilder() {
    }

    public static HttpRequestListenerBuilder aHttpRequestListener() {
        return new HttpRequestListenerBuilder();
    }

    public HttpRequestListenerBuilder withConfig(HttpServerConfig config) {
        this.config = config;
        return this;
    }

    public HttpRequestListenerBuilder withSender(Sender sender) {
        this.sender = sender;
        return this;
    }

    public HttpRequestListener build() {
        HttpRequestListener httpRequestListener = new HttpRequestListener(config, sender);
        return httpRequestListener;
    }
}
