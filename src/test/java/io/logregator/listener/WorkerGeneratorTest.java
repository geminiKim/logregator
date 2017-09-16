package io.logregator.listener;

import io.logregator.listener.http.HttpRequestAggregator;
import io.logregator.listener.http.HttpRequestListenerBuilder;
import io.logregator.worker.Worker;
import io.logregator.worker.WorkerGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class WorkerGeneratorTest {
    private HttpRequestAggregator httpListener;

    @Before
    public void setup() {
        httpListener = HttpRequestListenerBuilder.aHttpRequestListener().build();
    }

    @Test
    public void testShouldBeBuildWorkers() {
        Worker worker = WorkerGenerator.generate(httpListener);
        assertThat(worker, is(notNullValue()));
    }
}