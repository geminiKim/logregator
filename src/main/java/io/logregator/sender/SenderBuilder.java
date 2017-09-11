package io.logregator.sender;

import io.logregator.config.component.ComponentConfig;
import io.logregator.sender.http.HttpConfig;
import io.logregator.sender.http.HttpSender;
import io.logregator.sender.mongo.MongoConfig;
import io.logregator.sender.mongo.MongoSender;
import io.logregator.support.exception.LogregatorException;


public class SenderBuilder {
    public static Sender build(ComponentConfig config) {
        switch (config.getType()) {
            case http:
                HttpConfig http = new HttpConfig(config);
                return new HttpSender(http);
            case mongo:
                MongoConfig mongo = new MongoConfig(config);
                return new MongoSender(mongo);
        }
        throw new LogregatorException("do not supported component type");
    }
}
