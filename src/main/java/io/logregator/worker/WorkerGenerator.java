package io.logregator.worker;

import io.logregator.listener.Aggregator;
import io.logregator.listener.http.HttpRequestAggregator;
import io.logregator.listener.tailer.LogTailerAggregator;
import io.logregator.support.exception.LogregatorException;
import io.logregator.worker.http.HttpLogServer;
import io.logregator.worker.tailer.LogTailer;

public class WorkerGenerator {
    public static Worker generate(Aggregator aggregator) {
        switch (aggregator.getType()) {
            case http:
                return new HttpLogServer((HttpRequestAggregator) aggregator);
            case tail:
                return new LogTailer((LogTailerAggregator) aggregator);
        }
        throw new LogregatorException();
    }
}
