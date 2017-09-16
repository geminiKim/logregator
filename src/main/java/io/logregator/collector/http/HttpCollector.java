package io.logregator.collector.http;

import io.logregator.Aggregator;
import io.logregator.collector.Collector;
import io.logregator.config.ComponentType;
import io.logregator.support.exception.LogregatorException;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;

public class HttpCollector implements Collector {
    private final Aggregator aggregator;
    private final HttpServer server;
    private boolean work;

    public HttpCollector(Aggregator aggregator, HttpCollectorConfig config) {
        this.aggregator = aggregator;
        this.server = ServerBootstrap.bootstrap()
                                        .registerHandler(config.getUri(), new HttpCollectorHandler(this))
                                        .setListenerPort(config.getPort())
                                        .create();
        this.work = false;
    }

    @Override
    public void start() {
        try {
            server.start();
            work = true;
        } catch (Exception e) {
            throw new LogregatorException(e);
        }
    }

    @Override
    public void stop() {
        try {
            server.stop();
            work = false;
        } catch (Exception e) {
            throw new LogregatorException(e);
        }
    }

    @Override
    public void collect(String message) {
        aggregator.aggregate(message);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.http;
    }

    public boolean isWork() {
        return work;
    }
}
