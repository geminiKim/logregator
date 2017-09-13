package io.logregator.listener.tailer;

import io.logregator.config.component.ComponentType;
import io.logregator.listener.Listener;
import io.logregator.sender.Sender;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.input.TailerListenerAdapter;

@Slf4j
public class LogTailerListener extends TailerListenerAdapter implements Listener {
    private final TailerConfig config;
    private final Sender sender;

    public LogTailerListener(TailerConfig config, Sender sender) {
        this.config = config;
        this.sender = sender;
    }

    public void handle(String line) {
        sender.send(line);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.tail;
    }

    public TailerConfig getConfig() {
        return config;
    }
}
