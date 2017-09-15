package io.logregator;

import io.logregator.config.LogregatorConfig;
import io.logregator.listener.Listener;
import io.logregator.listener.ListenerBuilder;
import io.logregator.sender.Sender;
import io.logregator.sender.SenderBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
public class ComponentGenerator {
    public static List<Component> generate(LogregatorConfig config) {
        return config.getConfigs().stream()
                .map(each -> {
                    Sender sender = SenderBuilder.build(each.getSender());
                    Listener listener = ListenerBuilder.build(each.getListener(), sender);
                    log.info("Initial Config Listener - {} / Sender - {}", sender.toString(), listener.toString());
                    return new Component(sender, listener);
                })
                .collect(toList());
    }
}
