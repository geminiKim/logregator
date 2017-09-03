package io.logregator.sender;

import io.logregator.config.ComponentType;

public interface Sender {
    void send(String message);
    ComponentType getType();
}
