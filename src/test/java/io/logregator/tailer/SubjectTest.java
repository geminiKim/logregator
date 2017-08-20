package io.logregator.tailer;

import io.reactivex.subjects.PublishSubject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SubjectTest {
    @Test
    public void testShouldBeExecuteHttpPost() throws Exception {
        HttpClient http = mock(HttpClient.class);

        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(message -> {
            HttpPost request = new HttpPost("http://localhost:9999/test");
            request.setEntity(new StringEntity(message, ContentType.APPLICATION_JSON));
            http.execute(request);
        });

        subject.onNext("test");
        verify(http).execute(any(HttpPost.class));
    }
}
