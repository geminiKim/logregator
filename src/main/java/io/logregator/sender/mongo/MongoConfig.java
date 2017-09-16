package io.logregator.sender.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoTimeoutException;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.logregator.config.Config;
import io.logregator.support.exception.LogregatorException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

@Getter
@Setter
@Slf4j
public class MongoConfig {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    protected MongoConfig() {
    }

    public MongoConfig(Config config) {
        try {
            MongoClientOptions.Builder builder = MongoClientOptions.builder().connectTimeout(5000).socketTimeout(5000).serverSelectionTimeout(3000);
            client = new MongoClient(new ServerAddress(config.getConfigString("host"), config.getConfigInt("port")), builder.build());
            client.getAddress();
            database = client.getDatabase(config.getConfigString("database"));
            collection = database.getCollection(config.getConfigString("collection"));
        } catch (MongoTimeoutException e) {
            client.close();
            log.error("MongoClient initial failed", e);
            throw new LogregatorException();
        }
    }
}
