package io.logregator.sender.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public final class MongoConfigBuilder {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    private MongoConfigBuilder() {
    }

    public static MongoConfigBuilder aMongoConfig() {
        return new MongoConfigBuilder();
    }

    public MongoConfigBuilder withClient(MongoClient client) {
        this.client = client;
        return this;
    }

    public MongoConfigBuilder withDatabase(MongoDatabase database) {
        this.database = database;
        return this;
    }

    public MongoConfigBuilder withCollection(MongoCollection<Document> collection) {
        this.collection = collection;
        return this;
    }

    public MongoConfig build() {
        MongoConfig mongoConfig = new MongoConfig();
        mongoConfig.setClient(client);
        mongoConfig.setDatabase(database);
        mongoConfig.setCollection(collection);
        return mongoConfig;
    }
}
