package io.logregator;

import io.logregator.config.ConfigLoader;
import io.logregator.config.LogregatorConfig;
import io.logregator.worker.Worker;
import io.logregator.worker.WorkerBuilder;

import java.util.List;

public class Logregator {
    public static void main(String[] args) {
        LogregatorConfig config = ConfigLoader.load();

        List<Component> components = ComponentBuilder.build(config);
        List<Worker> workers = WorkerBuilder.build(components);

        for (Worker worker : workers) {
            worker.start();
        }
    }
}
