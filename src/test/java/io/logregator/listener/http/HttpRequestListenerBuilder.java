package io.logregator.listener.http;

import io.logregator.sender.Transporter;

public final class HttpRequestListenerBuilder {
    private HttpServerConfig config = HttpServerConfigBuilder.aHttpServerConfig().build();
    private Transporter transporter;

    private HttpRequestListenerBuilder() {
    }

    public static HttpRequestListenerBuilder aHttpRequestListener() {
        return new HttpRequestListenerBuilder();
    }

    public HttpRequestListenerBuilder withConfig(HttpServerConfig config) {
        this.config = config;
        return this;
    }

    public HttpRequestListenerBuilder withSender(Transporter transporter) {
        this.transporter = transporter;
        return this;
    }

    public HttpRequestAggregator build() {
        HttpRequestAggregator httpRequestListener = new HttpRequestAggregator(config, transporter);
        return httpRequestListener;
    }
}
