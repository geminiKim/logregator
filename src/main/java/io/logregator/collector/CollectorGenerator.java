package io.logregator.collector;

import io.logregator.Aggregator;
import io.logregator.collector.http.HttpCollector;
import io.logregator.collector.http.HttpCollectorConfig;
import io.logregator.collector.tailer.TailCollector;
import io.logregator.collector.tailer.TailCollectorConfig;
import io.logregator.config.Config;
import io.logregator.support.exception.LogregatorException;

public class CollectorGenerator {
    public static Collector generate(Aggregator aggregator, Config config) {
        switch (config.getType()) {
            case http:
                HttpCollectorConfig http = new HttpCollectorConfig(config);
                return new HttpCollector(aggregator, http);
            case tail:
                TailCollectorConfig tailer = new TailCollectorConfig(config);
                return new TailCollector(aggregator, tailer);
        }
        throw new LogregatorException();
    }
}
