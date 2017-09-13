package io.logregator.listener;

import io.logregator.config.component.ComponentConfig;
import io.logregator.listener.http.HttpRequestListener;
import io.logregator.listener.http.HttpServerConfig;
import io.logregator.listener.tailer.LogTailerListener;
import io.logregator.listener.tailer.TailerConfig;
import io.logregator.sender.Sender;
import io.logregator.support.exception.LogregatorException;

public class ListenerBuilder {
    public static Listener build(ComponentConfig config, Sender sender) {
        switch (config.getType()) {
            case tail:
                TailerConfig tailer = new TailerConfig(config);
                return new LogTailerListener(tailer, sender);
            case http:
                HttpServerConfig http = new HttpServerConfig(config);
                return new HttpRequestListener(http, sender);
        }
        throw new LogregatorException("do not supported component type");
    }
}
