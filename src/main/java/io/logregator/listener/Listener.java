package io.logregator.listener;

import io.logregator.config.ComponentType;

public interface Listener {
    ComponentType getType();
}
