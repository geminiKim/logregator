package io.logregator.listener;

import io.logregator.config.ComponentType;

public interface Aggregator {
    ComponentType getType();
}
