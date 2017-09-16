package io.logregator;

import io.logregator.config.ConfigLoader;
import io.logregator.config.LogregatorConfig;
import io.logregator.listener.Aggregator;
import io.logregator.listener.AggregatorGenerator;
import io.logregator.sender.Transporter;
import io.logregator.sender.TransporterGenerator;
import io.logregator.worker.Worker;
import io.logregator.worker.WorkerGenerator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Logregator {
    public static void main(String... args) {
        LogregatorConfig config = ConfigLoader.load();

        Transporter transporter = TransporterGenerator.generate(config.getAggregator());
        Aggregator aggregator = AggregatorGenerator.generate(config.getTransporter(), transporter);
        Worker worker = WorkerGenerator.generate(aggregator);

        log.info("Initial Worker ID - {}", worker.toString());
        worker.start();
    }
}
