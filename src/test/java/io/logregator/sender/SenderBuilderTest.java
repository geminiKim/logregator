package io.logregator.sender;

import io.logregator.config.ComponentType;
import io.logregator.config.ConfigDetail;
import io.logregator.config.ConfigDetailBuilder;
import org.apache.http.client.HttpClient;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class SenderBuilderTest {
    private final ConfigDetailBuilder configDetailBuilder = ConfigDetailBuilder.aConfigDetail();

    @Test
    public void testShouldBeBuildHttpSender() {
        ConfigDetail config = configDetailBuilder.withType(ComponentType.http).build();
        config.addConfig("url", "test");
        config.addConfig("_httpClient", mock(HttpClient.class));

        Sender sender = SenderBuilder.build(config);
        assertThat(sender.getType(), is(ComponentType.http));
    }
}