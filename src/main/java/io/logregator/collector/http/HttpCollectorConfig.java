package io.logregator.collector.http;

import io.logregator.config.Config;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpCollectorConfig {
    private String uri;
    private Integer port;

    protected HttpCollectorConfig() {
    }
    public HttpCollectorConfig(Config config) {
        uri = config.getConfigString("uri");
        port = config.getConfigInt("port");
    }
}
