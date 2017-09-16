package io.logregator.listener.http;

import io.logregator.config.ComponentType;
import io.logregator.listener.Aggregator;
import io.logregator.sender.Transporter;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpRequestAggregator implements HttpRequestHandler, Aggregator {
    private final HttpServerConfig config;
    private final Transporter transporter;

    public HttpRequestAggregator(HttpServerConfig config, Transporter transporter) {
        this.config = config;
        this.transporter = transporter;
    }

    @Override
    public void handle(HttpRequest request, HttpResponse response, HttpContext context) throws HttpException, IOException {
        switch (request.getRequestLine().getMethod()) {
            case HttpPost.METHOD_NAME:
                transporter.send(EntityUtils.toString(((BasicHttpEntityEnclosingRequest) request).getEntity()));
        }
    }

    @Override
    public ComponentType getType() {
        return ComponentType.http;
    }

    public HttpServerConfig getConfig() {
        return config;
    }
}
