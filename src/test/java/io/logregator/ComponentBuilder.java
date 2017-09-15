package io.logregator;

import io.logregator.listener.Listener;
import io.logregator.sender.Sender;

public final class ComponentBuilder {
    private Sender sender;
    private Listener listener;

    private ComponentBuilder() {
    }

    public static ComponentBuilder aComponent() {
        return new ComponentBuilder();
    }

    public ComponentBuilder withSender(Sender sender) {
        this.sender = sender;
        return this;
    }

    public ComponentBuilder withListener(Listener listener) {
        this.listener = listener;
        return this;
    }

    public Component build() {
        Component component = new Component(sender, listener);
        return component;
    }
}
