package io.logregator.listener.http;

import io.logregator.config.ComponentType;
import io.logregator.listener.Listener;
import io.logregator.sender.Sender;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpRequestListener implements HttpRequestHandler, Listener {
    private final Sender sender;

    public HttpRequestListener(Sender sender) {
        this.sender = sender;
    }

    @Override
    public void handle(HttpRequest request, HttpResponse response, HttpContext context) throws HttpException, IOException {
        switch (request.getRequestLine().getMethod()) {
            case HttpPost.METHOD_NAME:
                sender.send(EntityUtils.toString(((BasicHttpEntityEnclosingRequest) request).getEntity()));
        }
    }

    @Override
    public ComponentType getType() {
        return ComponentType.http;
    }
}
