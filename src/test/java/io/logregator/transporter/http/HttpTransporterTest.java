package io.logregator.transporter.http;

import io.logregator.transporter.Transporter;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HttpTransporterTest {
    private final HttpClient mockHttpClient = mock(HttpClient.class);
    private Transporter transporter;

    @Before
    public void setup() throws IOException {
        HttpTransporterConfig config = HttpConfigBuilder.aHttpConfig().withHttpClient(mockHttpClient)
                                                            .withUrl("/log")
                                                            .build();
        transporter = new HttpTransporter(config);
    }

    @Test
    public void testShouldBeSend() throws Exception {
        transporter.transport("test");
        verify(mockHttpClient).execute(any(HttpPost.class));
    }
}
