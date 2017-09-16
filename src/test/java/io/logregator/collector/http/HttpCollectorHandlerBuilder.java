package io.logregator.collector.http;

import io.logregator.collector.Collector;

public final class HttpCollectorHandlerBuilder {
    private Collector collector;

    private HttpCollectorHandlerBuilder() {
    }

    public static HttpCollectorHandlerBuilder builder() {
        return new HttpCollectorHandlerBuilder();
    }

    public HttpCollectorHandlerBuilder withCollector(Collector collector) {
        this.collector = collector;
        return this;
    }

    public HttpCollectorHandler build() {
        HttpCollectorHandler httpCollectorHandler = new HttpCollectorHandler(collector);
        return httpCollectorHandler;
    }
}
