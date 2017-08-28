package io.logregator.listener.tailer;

import io.logregator.sender.Sender;
import org.apache.commons.io.input.TailerListenerAdapter;

public class LogTailerListener extends TailerListenerAdapter {
    private final Sender sender;

    public LogTailerListener(Sender sender) {
        this.sender = sender;
    }

    public void handle(String line) {
        sender.send(line);
    }
}
