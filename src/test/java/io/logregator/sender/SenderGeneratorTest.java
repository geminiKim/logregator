package io.logregator.sender;

import io.logregator.config.ComponentConfigBuilder;
import io.logregator.config.component.ComponentConfig;
import io.logregator.config.component.ComponentType;
import org.apache.http.client.HttpClient;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class SenderGeneratorTest {
    private final ComponentConfigBuilder componentConfigBuilder = ComponentConfigBuilder.aConfigDetail();

    @Test
    public void testShouldBeBuildHttpSender() {
        ComponentConfig config = componentConfigBuilder.withType(ComponentType.http).build();
        config.addConfig("url", "test");
        config.addConfig("_httpClient", mock(HttpClient.class));

        Sender sender = SenderGenerator.build(config);
        assertThat(sender.getType(), is(ComponentType.http));
    }
}