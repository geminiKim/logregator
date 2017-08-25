package io.logregator.tailer;

import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.apache.http.protocol.HttpRequestHandler;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class HttpServerTest {
    @Test
    public void testShouldBeInitHttpServer() throws Exception {
        HttpRequestHandler handler = mock(HttpRequestHandler.class);
        HttpServer server = ServerBootstrap.bootstrap().registerHandler("/log", handler).setListenerPort(8888).create();
        server.start();
    }
}
