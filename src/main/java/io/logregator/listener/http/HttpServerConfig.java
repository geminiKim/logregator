package io.logregator.listener.http;

import io.logregator.config.Config;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpServerConfig {
    private String uri;
    private Integer port;

    protected HttpServerConfig() {
    }
    public HttpServerConfig(Config config) {
        uri = config.getConfigString("uri");
        port = config.getConfigInt("port");
    }
}
