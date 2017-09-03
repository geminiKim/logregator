package io.logregator.worker.http;

import io.logregator.support.exception.LogregatorException;
import io.logregator.worker.Worker;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.apache.http.protocol.HttpRequestHandler;

public class HttpLogServer implements Worker {
    private final HttpServer server;
    private boolean work;

    public HttpLogServer(HttpRequestHandler httpHandler) {
        this.server = ServerBootstrap.bootstrap().registerHandler("/log", httpHandler).setListenerPort(8888).create();
        this.work = false;
    }

    public void start() {
        try {
            server.start();
            work = true;
        } catch (Exception e) {
            throw new LogregatorException(e);
        }
    }

    public void stop() {
        try {
            server.stop();
            work = false;
        } catch (Exception e) {
            throw new LogregatorException(e);
        }
    }

    public boolean isWork() {
        return work;
    }
}
