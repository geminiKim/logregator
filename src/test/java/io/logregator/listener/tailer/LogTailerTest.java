package io.logregator.listener.tailer;

import io.logregator.support.ConcurrentTestFileWriter;
import io.logregator.support.TestFileLoader;
import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class LogTailerTest {
    private final TailerListener mockTailerListener = mock(LogTailerListener.class);

    private LogTailer tailer;

    @Before
    public void setup() throws IOException {
        tailer = new LogTailer(mockTailerListener);
    }

    @Test
    public void testShouldBeWork() {
        tailer.tail("./data/tailer/test.log");
        assertThat(tailer.isWork(), is(true));
    }

    @Test
    public void testShouldBeCallListenerHandleByLogging() throws Exception {
        Tailer.create(TestFileLoader.load("data/tailer/test.log"), mockTailerListener, 100, true);

        ConcurrentTestFileWriter.writeTestData("data/tailer/test.log", "logging", 3);

        Thread.sleep(300);
        verify(mockTailerListener, times(3)).handle(anyString());
    }
}