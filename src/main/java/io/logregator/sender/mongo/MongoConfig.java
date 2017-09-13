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
        client = new MongoClient(config.getConfigString("host"), config.getConfigInt("port"));
        database = client.getDatabase(config.getConfigString("database"));
        collection = database.getCollection(config.getConfigString("collection"));
    }
}
