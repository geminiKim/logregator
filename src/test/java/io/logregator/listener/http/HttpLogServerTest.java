package io.logregator.listener.http;

import io.logregator.worker.http.HttpLogServer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HttpLogServerTest {
    private final HttpRequestAggregator mockListener = mock(HttpRequestAggregator.class);
    private HttpLogServer server;

    @Before
    public void setUp() {
        when(mockListener.getConfig()).thenReturn(HttpServerConfigBuilder.aHttpServerConfig().build());
        server = new HttpLogServer(mockListener);
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