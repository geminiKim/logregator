package io.logregator.sender;

import io.logregator.config.ConfigDetail;
import io.logregator.sender.http.HttpSender;
import io.logregator.support.exception.LogregatorException;


public class SenderBuilder {
    public static Sender build(ConfigDetail config) {
        switch (config.getType()) {
            case http:
                return new HttpSender(config);
        }
        throw new LogregatorException("do not supported component type");
    }
}
