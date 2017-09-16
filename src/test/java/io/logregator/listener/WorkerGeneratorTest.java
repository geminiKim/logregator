package io.logregator.listener;

import com.google.common.collect.Lists;
import io.logregator.Component;
import io.logregator.ComponentBuilder;
import io.logregator.listener.http.HttpRequestListener;
import io.logregator.listener.http.HttpRequestListenerBuilder;
import io.logregator.worker.Worker;
import io.logregator.worker.WorkerGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WorkerGeneratorTest {
    private HttpRequestListener httpListener;
    private Component component;

    @Before
    public void setup() {
        httpListener = HttpRequestListenerBuilder.aHttpRequestListener().build();
        component = ComponentBuilder.aComponent().withListener(httpListener).build();
    }

    @Test
    public void testShouldBeBuildWorkers() {
        List<Worker> workers = WorkerGenerator.build(Lists.newArrayList(component));
        assertThat(workers.size(), is(1));
    }
}