package io.logregator.tailer;

import io.reactivex.subjects.PublishSubject;
import org.apache.commons.io.input.TailerListenerAdapter;

public class LogTailerListener extends TailerListenerAdapter {
    private final PublishSubject<String> subject;

    public LogTailerListener(PublishSubject<String> subject) {
        this.subject = subject;
    }

    public void handle(String line) {
        subject.onNext(line);
    }
}
