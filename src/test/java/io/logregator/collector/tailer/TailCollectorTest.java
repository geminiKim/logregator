package io.logregator.collector.tailer;

import io.logregator.Aggregator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class TailCollectorTest {
    private final Aggregator mockAggregator = mock(Aggregator.class);
    private final TailCollectorConfig config = TailCollectorConfigBuilder.builder().withPath("data/tailer/test.log").build();

    private TailCollector tailer;

    @Before
    public void setup() throws IOException {
        tailer = new TailCollector(mockAggregator, config);
    }

    @Test
    public void testShouldBeWorking() {
        tailer.start();
        assertThat(tailer.isWork(), is(true));
    }
}