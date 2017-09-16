package io.logregator.listener.tailer;

import io.logregator.config.ComponentType;
import io.logregator.listener.Aggregator;
import io.logregator.sender.Transporter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.input.TailerListenerAdapter;

@Slf4j
public class LogTailerAggregator extends TailerListenerAdapter implements Aggregator {
    private final TailerConfig config;
    private final Transporter transporter;

    public LogTailerAggregator(TailerConfig config, Transporter transporter) {
        this.config = config;
        this.transporter = transporter;
    }

    public void handle(String line) {
        transporter.send(line);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.tail;
    }

    public TailerConfig getConfig() {
        return config;
    }
}
