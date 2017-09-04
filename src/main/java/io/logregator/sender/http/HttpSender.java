package io.logregator.sender.http;

import io.logregator.config.ComponentType;
import io.logregator.config.ConfigDetail;
import io.logregator.sender.Sender;
import io.reactivex.subjects.PublishSubject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

@Slf4j
public class HttpSender implements Sender {
    private final HttpClient http;
    private final PublishSubject<String> subject;

    public HttpSender(ConfigDetail config) {
        this.http = config.getConfigValue("_httpClient", HttpClient.class);
        subject = PublishSubject.create();
        subject.subscribe(message -> {
            try {
                HttpPost request = new HttpPost(config.getConfigValue("url", String.class));
                request.setEntity(new StringEntity(message, ContentType.APPLICATION_JSON));
                HttpResponse response = http.execute(request);
                response.setEntity(new StringEntity(message, ContentType.APPLICATION_JSON));
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
