package io.logregator.collector;

import io.logregator.config.ComponentType;

public interface Collector {
    void start();
    void stop();
    void collect(String message);
    ComponentType getType();
}
