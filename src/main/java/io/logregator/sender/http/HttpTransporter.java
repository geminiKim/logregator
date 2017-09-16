package io.logregator.sender.http;

import io.logregator.config.ComponentType;
import io.logregator.sender.Transporter;
import io.reactivex.subjects.PublishSubject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

@Slf4j
public class HttpTransporter implements Transporter {
    private final HttpConfig config;
    private final PublishSubject<String> subject;

    public HttpTransporter(HttpConfig configuration) {
        config = configuration;
        subject = PublishSubject.create();
        subject.subscribe(message -> {
            try {
                HttpPost request = new HttpPost(config.getUrl());
                request.setEntity(new StringEntity(message, ContentType.APPLICATION_JSON));
                config.getHttpClient().execute(request);
            } catch (Exception e) {
                log.error("send fail", e);
            }
        });
    }

    public void send(String message) {
        subject.onNext(message);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.http;
    }
}
