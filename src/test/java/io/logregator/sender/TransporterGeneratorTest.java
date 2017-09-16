package io.logregator.sender;

import io.logregator.config.ComponentType;
import io.logregator.config.Config;
import io.logregator.config.ConfigBuilder;
import org.apache.http.client.HttpClient;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class TransporterGeneratorTest {
    private final ConfigBuilder configBuilder = ConfigBuilder.aConfigDetail();

    @Test
    public void testShouldBeBuildHttpSender() {
        Config config = configBuilder.withType(ComponentType.http).build();
        config.addConfig("url", "test");
        config.addConfig("_httpClient", mock(HttpClient.class));

        Transporter transporter = TransporterGenerator.generate(config);
        assertThat(transporter.getType(), is(ComponentType.http));
    }
}