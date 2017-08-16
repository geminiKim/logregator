package io.logregator.tailer;

import org.apache.commons.io.input.TailerListener;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class LogTailerTest {

    @Test
    public void testShouleBeInitialize() {
        TailerListener listener = mock(LogTailerListener.class);
        LogTailer tailer = new LogTailer(listener);

        tailer.tail("./data/tailer/test.log");
        assertThat(tailer.isWork(), is(true));
    }
}