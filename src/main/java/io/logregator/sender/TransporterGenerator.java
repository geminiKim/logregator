package io.logregator.sender;

import io.logregator.config.Config;
import io.logregator.sender.http.HttpConfig;
import io.logregator.sender.http.HttpTransporter;
import io.logregator.sender.mongo.MongoConfig;
import io.logregator.sender.mongo.MongoTransporter;
import io.logregator.support.exception.LogregatorException;


public class TransporterGenerator {
    public static Transporter generate(Config config) {
        switch (config.getType()) {
            case http:
                HttpConfig http = new HttpConfig(config);
                return new HttpTransporter(http);
            case mongo:
                MongoConfig mongo = new MongoConfig(config);
                return new MongoTransporter(mongo);
        }
        throw new LogregatorException("do not supported component type");
    }
}
