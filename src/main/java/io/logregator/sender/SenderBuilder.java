package io.logregator.sender;

import io.logregator.config.component.ComponentConfig;
import io.logregator.sender.http.HttpSender;
import io.logregator.sender.mongo.MongoConfig;
import io.logregator.sender.mongo.MongoLogWriter;
import io.logregator.sender.mongo.MongoSender;
import io.logregator.support.exception.LogregatorException;
import org.apache.http.impl.client.HttpClientBuilder;


public class SenderBuilder {
    public static Sender build(ComponentConfig config) {
        switch (config.getType()) {
            case http:
                config.addConfig("_httpClient", HttpClientBuilder.create().build());
                return new HttpSender(config);
            case mongo:
                MongoConfig mongo = new MongoConfig(config);
                return new MongoSender(new MongoLogWriter(mongo));
        }
        throw new LogregatorException("do not supported component type");
    }
}
