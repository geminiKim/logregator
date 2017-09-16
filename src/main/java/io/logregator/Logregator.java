package io.logregator;

import io.logregator.config.ConfigLoader;
import io.logregator.config.LogregatorConfig;

public class Logregator {
    public static void main(String... args) {
        LogregatorConfig config = ConfigLoader.load();

        Aggregator aggregator = new Aggregator(config);
        aggregator.start();
    }
}
