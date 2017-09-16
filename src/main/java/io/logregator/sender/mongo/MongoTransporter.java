package io.logregator.sender.mongo;

import io.logregator.config.ComponentType;
import io.logregator.sender.Transporter;
import io.logregator.support.util.JsonUtils;
import io.reactivex.subjects.PublishSubject;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import java.util.Map;

@Slf4j
public class MongoTransporter implements Transporter {
    private final MongoConfig config;
    private final PublishSubject<String> subject;

    public MongoTransporter(MongoConfig configuration) {
        config = configuration;
        subject = PublishSubject.create();
        subject.subscribe(message -> {
            Map log = JsonUtils.fromJson(message, Map.class);
            config.getCollection().insertOne(new Document(log));
        });
    }

    @Override
    public void send(String message) {
        subject.onNext(message);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.mongo;
    }
}
