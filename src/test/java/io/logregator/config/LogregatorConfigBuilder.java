package io.logregator.config;

public final class LogregatorConfigBuilder {
    private Config aggregator;
    private Config transporter;

    private LogregatorConfigBuilder() {
    }

    public static LogregatorConfigBuilder aLogregatorConfig() {
        return new LogregatorConfigBuilder();
    }

    public LogregatorConfigBuilder withAggregator(Config aggregator) {
        this.aggregator = aggregator;
        return this;
    }

    public LogregatorConfigBuilder withTransporter(Config transporter) {
        this.transporter = transporter;
        return this;
    }

    public LogregatorConfig build() {
        LogregatorConfig logregatorConfig = new LogregatorConfig();
        logregatorConfig.setAggregator(aggregator);
        logregatorConfig.setTransporter(transporter);
        return logregatorConfig;
    }
}
