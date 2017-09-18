package io.logregator;

import io.logregator.config.ConfigLoader;
import io.logregator.config.LogregatorArgument;
import io.logregator.config.LogregatorConfig;
import io.logregator.support.LoggerConfig;

public class Logregator {
    public static void main(String... args) {
        LogregatorArgument argument = new LogregatorArgument(args);
        LogregatorConfig config = ConfigLoader.load(argument);

        LoggerConfig.initialize(config);

        Aggregator aggregator = new Aggregator(config);
        aggregator.start();
    }
}
