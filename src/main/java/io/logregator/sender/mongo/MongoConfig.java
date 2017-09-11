package io.logregator.sender.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.logregator.config.component.ComponentConfig;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

@Getter
@Setter
public class MongoConfig {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    protected MongoConfig() {
    }

    public MongoConfig(ComponentConfig config) {
        client = new MongoClient(config.getConfigValue("host", String.class), config.getConfigValue("port", Integer.class));
        database = client.getDatabase(config.getConfigValue("database", String.class));
        collection = database.getCollection(config.getConfigValue("collection", String.class));
    }
}
