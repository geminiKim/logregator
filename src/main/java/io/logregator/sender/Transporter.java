package io.logregator.sender;

import io.logregator.config.ComponentType;

public interface Transporter {
    void send(String message);
    ComponentType getType();
}
