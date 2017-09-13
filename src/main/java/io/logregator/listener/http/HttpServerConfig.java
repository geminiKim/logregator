package io.logregator.listener.http;

import io.logregator.config.component.ComponentConfig;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpServerConfig {
    private String uri;
    private Integer port;

    protected HttpServerConfig() {
    }
    public HttpServerConfig(ComponentConfig config) {
        uri = config.getConfigString("uri");
        port = config.getConfigInt("port");
    }
}
