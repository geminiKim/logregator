package io.logregator.transporter;

import io.logregator.config.ComponentType;

public interface Transporter {
    void transport(String message);
    ComponentType getType();
}
