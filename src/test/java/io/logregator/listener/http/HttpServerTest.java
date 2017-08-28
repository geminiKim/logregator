package io.logregator.listener.http;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpRequestHandler;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HttpServerTest {
    private final HttpRequestHandler mockHttpHandler = mock(HttpRequestHandler.class);
    private HttpServer server;

    @Before
    public void setup() throws IOException {
        server = ServerBootstrap.bootstrap().registerHandler("/log", mockHttpHandler).setListenerPort(8888).create();
        server.start();
    }

    @Test
    public void testShouldBeCallHandleByHttpRequest() throws Exception {
        HttpClient http = HttpClientBuilder.create().build();
        http.execute(new HttpPost("http://localhost:8888/log"));

        verify(mockHttpHandler).handle(any(), any(), any());
    }
}
