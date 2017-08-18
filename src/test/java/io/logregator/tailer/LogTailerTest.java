package io.logregator.tailer;

import io.logregator.support.ConcurrentTestFileWriter;
import io.logregator.support.TestFileLoader;
import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class LogTailerTest {
    @Test
    public void testShouldBeCallListenerHandleByLogging() throws Exception {
        TailerListener listener = mock(LogTailerListener.class);
        Tailer.create(TestFileLoader.load("data/tailer/test.log"), listener, 100, true);

        ConcurrentTestFileWriter.writeTestData("data/tailer/test.log", "logging", 3);

        Thread.sleep(300);
        verify(listener, times(3)).handle(anyString());
    }

    @Test
    public void testShouldBeWork() {
        TailerListener listener = mock(LogTailerListener.class);
        LogTailer tailer = new LogTailer(listener);

        tailer.tail("./data/tailer/test.log");
        assertThat(tailer.isWork(), is(true));
    }
}