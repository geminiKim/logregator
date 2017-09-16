package io.logregator.collector.http;

import io.logregator.Aggregator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class HttpCollectorTest {
    private final Aggregator mockAggregator = mock(Aggregator.class);
    private final HttpCollectorConfig config = HttpCollectorConfigBuilder.builder().build();

    private HttpCollector server;

    @Before
    public void setUp() {
        server = new HttpCollector(mockAggregator, config);
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