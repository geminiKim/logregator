package io.logregator.listener.http;

import io.logregator.worker.http.HttpLogServer;
import org.apache.http.protocol.HttpRequestHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class HttpLogServerTest {
    private final HttpRequestHandler mockHandler = mock(HttpRequestHandler.class);
    private HttpLogServer server;

    @Before
    public void setUp() {
        server = new HttpLogServer(mockHandler);
    }

    @Test
    public void testShouldBeStartServer() {
        server.start();
        assertTrue(server.isWork());
    }

    @Test
    public void testShouldBeStopServer() {
        server.stop();
        assertFalse(server.isWork());
    }
}