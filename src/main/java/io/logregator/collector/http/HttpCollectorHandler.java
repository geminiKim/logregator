package io.logregator.collector.http;

import io.logregator.collector.Collector;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpCollectorHandler implements HttpRequestHandler {
    private final Collector collector;

    public HttpCollectorHandler(Collector collector) {
        this.collector = collector;
    }

    @Override
    public void handle(HttpRequest request, HttpResponse response, HttpContext context) throws HttpException, IOException {
        switch (request.getRequestLine().getMethod()) {
            case HttpPost.METHOD_NAME:
                String message = EntityUtils.toString(((BasicHttpEntityEnclosingRequest) request).getEntity());
                collector.collect(message);
                response.setEntity(new StringEntity("{\"result\":\"OK\"}", ContentType.APPLICATION_JSON));
        }
    }
}
