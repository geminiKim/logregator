package io.logregator.sender.mongo;

import io.logregator.config.component.ComponentType;
import io.logregator.sender.Sender;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MongoSender implements Sender {
    private final MongoLogWriter writer;

    public MongoSender(MongoLogWriter writer) {
        this.writer = writer;
    }

    @Override
    public void send(String message) {
        writer.write(message);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.mongo;
    }
}
