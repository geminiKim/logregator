package io.logregator.listener;

import io.logregator.config.component.ComponentType;

public interface Listener {
    ComponentType getType();
}
