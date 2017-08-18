package io.logregator.tailer;

import io.reactivex.subjects.Subject;
import org.apache.commons.io.input.TailerListener;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LogTailerListenerTest {
    @Test
    public void testShouldBeCallOnNext() throws Exception {
        Subject subject = mock(Subject.class);
        TailerListener listener = new LogTailerListener(subject);

        listener.handle("test");
        verify(subject).onNext("test");
    }
}
