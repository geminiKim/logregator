package io.logregator;

import io.logregator.collector.Collector;
import io.logregator.collector.CollectorGenerator;
import io.logregator.config.LogregatorConfig;
import io.logregator.transporter.Transporter;
import io.logregator.transporter.TransporterGenerator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Aggregator {
    private Collector collector;
    private Transporter transporter;

    public Aggregator(LogregatorConfig config) {
        collector = CollectorGenerator.generate(this, config.getAggregator());
        transporter = TransporterGenerator.generate(config.getTransporter());
    }

    public void start() {
        log.info("Start Worker ID:{} | Collector:{} | Transporter:{}", Integer.toHexString(hashCode()), collector.getType(), transporter.getType());
        collector.start();
    }

    public void stop() {
        log.info("Stop Worker ID:{} | Collector:{} | Transporter:{}", Integer.toHexString(hashCode()), collector.getType(), transporter.getType());
        collector.stop();
    }

    public void aggregate(String message) {
        transporter.transport(message);
    }
}
