package io.logregator;

import io.logregator.config.ConfigLoader;
import io.logregator.config.LogregatorConfig;
import io.logregator.worker.Worker;
import io.logregator.worker.WorkerGenerator;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Logregator {
    public static void main(String... args) {
        LogregatorConfig config = ConfigLoader.load();

        List<Component> components = ComponentGenerator.generate(config);
        List<Worker> workers = WorkerGenerator.build(components);

        for (Worker worker : workers) {
            log.info("Initial Worker ID - {}", worker.toString());
            worker.start();
        }
    }
}
