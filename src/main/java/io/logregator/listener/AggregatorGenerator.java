package io.logregator.listener;

import io.logregator.config.Config;
import io.logregator.listener.http.HttpRequestAggregator;
import io.logregator.listener.http.HttpServerConfig;
import io.logregator.listener.tailer.LogTailerAggregator;
import io.logregator.listener.tailer.TailerConfig;
import io.logregator.sender.Transporter;
import io.logregator.support.exception.LogregatorException;

public class AggregatorGenerator {
    public static Aggregator generate(Config config, Transporter transporter) {
        switch (config.getType()) {
            case tail:
                TailerConfig tailer = new TailerConfig(config);
                return new LogTailerAggregator(tailer, transporter);
            case http:
                HttpServerConfig http = new HttpServerConfig(config);
                return new HttpRequestAggregator(http, transporter);
        }
        throw new LogregatorException("do not supported component type");
    }
}
