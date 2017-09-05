package io.logregator.listener;

import io.logregator.config.component.ComponentConfig;
import io.logregator.listener.http.HttpRequestListener;
import io.logregator.listener.tailer.LogTailerListener;
import io.logregator.sender.Sender;
import io.logregator.support.exception.LogregatorException;

public class ListenerBuilder {
    public static Listener build(ComponentConfig config, Sender sender) {
        switch (config.getType()) {
            case tail:
                return new LogTailerListener(sender, config);
            case http:
                return new HttpRequestListener(sender);
        }
        throw new LogregatorException("do not supported component type");
    }
}
