package io.logregator.sender.http;

import io.logregator.config.component.ComponentType;
import io.logregator.sender.Sender;
import io.reactivex.subjects.PublishSubject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

@Slf4j
public class HttpSender implements Sender {
    private final PublishSubject<String> subject;

    public HttpSender(HttpConfig config) {
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
