package io.logregator.sender.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.logregator.config.component.ComponentConfig;
import org.bson.Document;

public class MongoLogWriter {
    private final MongoClient client;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public MongoLogWriter(ComponentConfig config) {
        client = new MongoClient(config.getConfigValue("host", String.class), config.getConfigValue("port", Integer.class));
        database = client.getDatabase(config.getConfigValue("database", String.class));
        collection = database.getCollection(config.getConfigValue("collection", String.class));
    }

    public void write(String message) {

    }
}
