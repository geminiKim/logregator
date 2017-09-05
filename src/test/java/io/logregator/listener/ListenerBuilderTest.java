package io.logregator.listener;

import io.logregator.config.ConfigDetailBuilder;
import io.logregator.config.component.ComponentConfig;
import io.logregator.config.component.ComponentType;
import io.logregator.sender.http.HttpSender;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ListenerBuilderTest {
    private final ConfigDetailBuilder configDetailBuilder = ConfigDetailBuilder.aConfigDetail();

    @Test
    public void testShouldBeBuildHttpListener() {
        ComponentConfig config = configDetailBuilder.withType(ComponentType.http).build();

        Listener listener = ListenerBuilder.build(config, mock(HttpSender.class));
        assertThat(listener.getType(), is(ComponentType.http));
    }

}