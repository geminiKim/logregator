package io.logregator.listener.tailer;

import io.logregator.config.ComponentType;
import io.logregator.config.ConfigDetail;
import io.logregator.listener.Listener;
import io.logregator.sender.Sender;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.input.TailerListenerAdapter;

@Slf4j
public class LogTailerListener extends TailerListenerAdapter implements Listener {
    private final Sender sender;
    private final String path;

    public LogTailerListener(Sender sender, ConfigDetail config) {
        this.sender = sender;
        this.path = config.getConfigValue("filePath", String.class);
    }

    public void handle(String line) {
        sender.send(line);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.tail;
    }

    public String getPath() {
        return path;
    }
}
