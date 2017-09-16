package io.logregator.transporter;

import io.logregator.config.Config;
import io.logregator.support.exception.LogregatorException;
import io.logregator.transporter.http.HttpTransporter;
import io.logregator.transporter.http.HttpTransporterConfig;
import io.logregator.transporter.mongo.MongoTransporter;
import io.logregator.transporter.mongo.MongoTransporterConfig;


public class TransporterGenerator {
    public static Transporter generate(Config config) {
        switch (config.getType()) {
            case http:
                HttpTransporterConfig http = new HttpTransporterConfig(config);
                return new HttpTransporter(http);
            case mongo:
                MongoTransporterConfig mongo = new MongoTransporterConfig(config);
                return new MongoTransporter(mongo);
        }
        throw new LogregatorException("do not supported component type");
    }
}
