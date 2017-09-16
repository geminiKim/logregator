package io.logregator.collector.tailer;

import io.logregator.collector.Collector;
import io.logregator.support.ConcurrentTestFileWriter;
import io.logregator.support.TestFileLoader;
import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TailCollectorCollectorTest {
    private final Collector mockCollector = mock(Collector.class);

    private TailerListener listener;

    @Before
    public void setup() {
        listener = new TailCollectorListener(mockCollector);
    }

    @Test
    public void testShouldBeCallSend() throws Exception {
        listener.handle("test");
        verify(mockCollector).collect("test");
    }

    @Test
    public void testShouldBeCallListenerHandleByLogging() throws Exception {
        Tailer.create(TestFileLoader.load("data/tailer/test.log"), listener, 100, true);

        ConcurrentTestFileWriter.writeTestData("data/tailer/test.log", "logging", 3);

        Thread.sleep(300);
        verify(mockCollector, times(3)).collect(anyString());
    }
}
