package io.logregator.sender.mongo;

import io.logregator.support.util.JsonUtils;
import org.bson.Document;

import java.util.Map;

public class MongoLogWriter {
    private final MongoConfig config;

    public MongoLogWriter(MongoConfig config) {
        this.config = config;
    }

    public void write(String message) {
        Map log = JsonUtils.fromJson(message, Map.class);
        config.getCollection().insertOne(new Document(log));
    }
}
