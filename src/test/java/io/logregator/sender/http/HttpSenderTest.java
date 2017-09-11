package io.logregator.sender.http;

import com.google.common.collect.Maps;
import io.logregator.config.ComponentConfigBuilder;
import io.logregator.config.component.ComponentConfig;
import io.logregator.sender.Sender;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HttpSenderTest {
    private final HttpClient mockHttpClient = mock(HttpClient.class);
    private Sender sender;

    private HashMap<String, Object> buildTestConfig() {
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("url", "test");
        map.put("_httpClient", mockHttpClient);
        return map;
    }

    @Before
    public void setup() throws IOException {
        HashMap<String, Object> map = buildTestConfig();

        ComponentConfig build = ComponentConfigBuilder.aConfigDetail()
                                    .withConfig(map)
                                    .build();
        sender = new HttpSender(build);
    }

    @Test
    public void testShouldBeSend() throws Exception {
        sender.send("test");
        verify(mockHttpClient).execute(any(HttpPost.class));
    }
}
