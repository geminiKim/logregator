package io.logregator.tailer;

import io.reactivex.subjects.Subject;
import org.apache.commons.io.input.TailerListenerAdapter;

public class LogTailerListener extends TailerListenerAdapter {
    private final Subject<String> subject;

    public LogTailerListener(Subject<String> subject) {
        this.subject = subject;
    }

    public void handle(String line) {
        subject.onNext(line);
    }
}
