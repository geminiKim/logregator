package io.logregator.listener;

import io.logregator.config.ComponentType;
import io.logregator.config.Config;
import io.logregator.config.ConfigBuilder;
import io.logregator.sender.http.HttpTransporter;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class AggregatorGeneratorTest {
    private final ConfigBuilder configBuilder = ConfigBuilder.aConfigDetail();

    @Test
    public void testShouldBeBuildHttpListener() {
        Config config = configBuilder.withType(ComponentType.http).build();

        Aggregator aggregator = AggregatorGenerator.generate(config, mock(HttpTransporter.class));
        assertThat(aggregator.getType(), is(ComponentType.http));
    }

}