package io.logregator.sender.http;

import io.logregator.sender.Sender;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HttpSenderTest {
    private final HttpClient mockHttpClient = mock(HttpClient.class);
    private Sender sender;

    @Before
    public void setup() throws IOException {
        HttpConfig config = HttpConfigBuilder.aHttpConfig().withHttpClient(mockHttpClient)
                                                            .withUrl("/log")
                                                            .build();
        sender = new HttpSender(config);
    }

    @Test
    public void testShouldBeSend() throws Exception {
        sender.send("test");
        verify(mockHttpClient).execute(any(HttpPost.class));
    }
}
