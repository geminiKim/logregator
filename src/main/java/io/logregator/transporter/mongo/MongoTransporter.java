package io.logregator.transporter.mongo;

import io.logregator.config.ComponentType;
import io.logregator.support.util.JsonUtils;
import io.logregator.transporter.Transporter;
import io.reactivex.subjects.PublishSubject;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import java.util.Map;

@Slf4j
public class MongoTransporter implements Transporter {
    private final MongoTransporterConfig config;
    private final PublishSubject<String> subject;

    public MongoTransporter(MongoTransporterConfig configuration) {
        config = configuration;
        subject = PublishSubject.create();
        subject.subscribe(message -> {
            try {
                Map log = JsonUtils.fromJson(message, Map.class);
                config.getCollection().insertOne(new Document(log));
            } catch (Exception e1) {
                try {
                    config.getCollection().insertOne(new Document("log", message));
                } catch (Exception e2) {
                    log.error("Mongo transport fail", e1);
                }
            }
        });
    }

    @Override
    public void transport(String message) {
        subject.onNext(message);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.mongo;
    }
}
