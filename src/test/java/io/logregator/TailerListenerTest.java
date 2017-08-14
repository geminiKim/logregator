package io.logregator;

import io.logregator.support.ConcurrentTestFileWriter;
import io.logregator.support.TestFileLoader;
import io.reactivex.subjects.PublishSubject;
import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import org.apache.commons.io.input.TailerListenerAdapter;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TailerListenerTest {
    @Test
    public void testShouldBeCallTailerListenerHandleByLogging() throws Exception {
        TailerListener listener = mock(LogTailerListener.class);
        Tailer.create(TestFileLoader.load("data/tailer/test.log"), listener, 100, true);

        ConcurrentTestFileWriter.writeTestData("data/tailer/test.log", "logging", 3);

        Thread.sleep(300);
        verify(listener, times(3)).handle(anyString());
    }

    public class LogTailerListener extends TailerListenerAdapter {
        private final PublishSubject<String> subject;

        public LogTailerListener(PublishSubject<String> subject) {
            this.subject = subject;
        }

        public void handle(String line) {
            subject.onNext(line);
        }
    }
}
