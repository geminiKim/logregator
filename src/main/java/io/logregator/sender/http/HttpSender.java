package io.logregator.sender.http;

import io.logregator.config.ComponentType;
import io.logregator.config.ConfigDetail;
import io.logregator.sender.Sender;
import io.reactivex.subjects.PublishSubject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

public class HttpSender implements Sender {
    private final HttpClient http;
    private final PublishSubject<String> subject;

    public HttpSender(ConfigDetail config) {
        this.http = config.getConfigValue("_httpClient", HttpClient.class);
        subject = PublishSubject.create();
        subject.subscribe(message -> {
            HttpPost request = new HttpPost(config.getConfigValue("url", String.class));
            request.setEntity(new StringEntity(message, ContentType.APPLICATION_JSON));
            http.execute(request);
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
