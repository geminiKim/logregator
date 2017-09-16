package io.logregator.worker;

import io.logregator.Component;
import io.logregator.listener.http.HttpRequestListener;
import io.logregator.listener.tailer.LogTailerListener;
import io.logregator.worker.http.HttpLogServer;
import io.logregator.worker.tailer.LogTailer;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class WorkerGenerator {
    public static List<Worker> build(List<Component> components) {
        return components.stream().map(each -> {
            switch (each.getListener().getType()) {
                case http:
                    return new HttpLogServer((HttpRequestListener) each.getListener());
                case tail:
                    return new LogTailer((LogTailerListener) each.getListener());
            }
            return null;
        })
        .collect(toList());
    }
}
