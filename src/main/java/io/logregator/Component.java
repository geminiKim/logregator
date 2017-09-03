package io.logregator;

import io.logregator.listener.Listener;
import io.logregator.sender.Sender;
import lombok.Getter;

@Getter
public class Component {
    private final Sender sender;
    private final Listener listener;

    public Component(Sender sender, Listener listener) {
        this.sender = sender;
        this.listener = listener;
    }
}
