package io.logregator.sender.http;

import io.logregator.config.Config;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

@Getter
@Setter
public class HttpConfig {
    private HttpClient httpClient;
    private String url;

    protected HttpConfig() {
    }

    public HttpConfig(Config config) {
        httpClient = HttpClientBuilder.create().build();
        url = config.getConfigString("url");
    }
}
