package io.logregator.collector.tailer;

import io.logregator.Aggregator;
import io.logregator.collector.Collector;
import io.logregator.config.ComponentType;
import org.apache.commons.io.input.Tailer;

import java.io.File;

public class TailCollector implements Collector {
    private final Aggregator aggregator;
    private final Tailer tailer;
    private boolean work;

    public TailCollector(Aggregator aggregator, TailCollectorConfig config) {
        this.aggregator = aggregator;
        this.tailer = new Tailer(new File(config.getPath()), new TailCollectorListener(this), 100, true);
        this.work = false;
    }

    @Override
    public void start() {
        if(work == true) return;
        Thread thread = new Thread(tailer);
        thread.start();
        work = true;
    }

    @Override
    public void stop() {
        if(work == false) return;
        tailer.stop();
        work = false;
    }

    @Override
    public void collect(String message) {
        aggregator.aggregate(message);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.tail;
    }

    public boolean isWork() {
        return work;
    }
}
