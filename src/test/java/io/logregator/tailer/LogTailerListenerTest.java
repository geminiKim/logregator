package io.logregator.tailer;

import io.logregator.sender.Sender;
import org.apache.commons.io.input.TailerListener;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LogTailerListenerTest {
    @Test
    public void testShouldBeCallSend() throws Exception {
        Sender sender = mock(Sender.class);
        TailerListener listener = new LogTailerListener(sender);

        listener.handle("test");
        verify(sender).send("test");
    }
}
