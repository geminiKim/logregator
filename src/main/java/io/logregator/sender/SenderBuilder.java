package io.logregator.sender;

import io.logregator.config.ConfigDetail;
import io.logregator.sender.http.HttpSender;
import io.logregator.support.exception.LogregatorException;
import org.apache.http.impl.client.HttpClientBuilder;


public class SenderBuilder {
    public static Sender build(ConfigDetail config) {
        switch (config.getType()) {
            case http:
                config.addConfig("_httpClient", HttpClientBuilder.create().build());
                return new HttpSender(config);
        }
        throw new LogregatorException("do not supported component type");
    }
}
