package io.logregator;

import io.logregator.config.LogregatorConfig;
import io.logregator.listener.Listener;
import io.logregator.listener.ListenerBuilder;
import io.logregator.sender.Sender;
import io.logregator.sender.SenderBuilder;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ComponentBuilder {
    public static List<Component> build(LogregatorConfig config) {
        return config.getConfigs().stream()
                .map(each -> {
                    Sender sender = SenderBuilder.build(each.getSender());
                    Listener listener = ListenerBuilder.build(each.getListener(), sender);
                    return new Component(sender, listener);
                })
                .collect(toList());
    }
}
