package io.logregator.collector.tailer;

import io.logregator.collector.Collector;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.input.TailerListenerAdapter;

@Slf4j
public class TailCollectorListener extends TailerListenerAdapter {
    private final Collector collector;

    public TailCollectorListener(Collector collector) {
        this.collector = collector;
    }

    public void handle(String message) {
        collector.collect(message);
    }
}
