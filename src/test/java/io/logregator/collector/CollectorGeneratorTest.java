package io.logregator.collector;

import io.logregator.Aggregator;
import io.logregator.config.ComponentType;
import io.logregator.config.Config;
import io.logregator.config.ConfigBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.mock;

public class CollectorGeneratorTest {
    private final Aggregator mockAggregator = mock(Aggregator.class);
    private final Config config = ConfigBuilder.aConfigDetail().withType(ComponentType.http).build();


    @Before
    public void setup() {
        config.addConfig("port", 9999);
    }

    @Test
    public void testShouldBeBuildWorkers() {
        Collector collector = CollectorGenerator.generate(mockAggregator, config);
        assertThat(collector, is(notNullValue()));
    }
}