package io.logregator.tailer;

import io.logregator.sender.Sender;
import io.logregator.sender.http.HttpSender;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HttpSenderTest {
    @Test
    public void testShouldBeSend() throws Exception {
        HttpClient http = mock(HttpClient.class);
        Sender sender = new HttpSender(http);

        sender.send("test");
        verify(http).execute(any(HttpPost.class));
    }

}
