package io.logregator.listener.tailer;

import io.logregator.config.ComponentConfigBuilder;
import io.logregator.sender.Sender;
import org.apache.commons.io.input.TailerListener;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LogTailerListenerTest {
    private final Sender mockSender = mock(Sender.class);

    private TailerListener listener;

    @Before
    public void setup() {
        listener = new LogTailerListener(mockSender, ComponentConfigBuilder.aConfigDetail().build());
    }

    @Test
    public void testShouldBeCallSend() throws Exception {
        listener.handle("test");
        verify(mockSender).send("test");
    }
}
