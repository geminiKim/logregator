package io.logregator.collector.http;

import io.logregator.collector.Collector;
import org.apache.http.HttpRequest;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HttpCollectorHandlerTest {
    private final Collector mockCollector = mock(Collector.class);

    private HttpCollectorHandler httpRequestListener;

    @Before
    public void setup() {
        httpRequestListener = new HttpCollectorHandler(mockCollector);
    }

    @Test
    public void testShouldBeCallHandleByHttpRequest() throws Exception {
        HttpRequest request = buildLogHttpRequest("test");

        httpRequestListener.handle(request, null, null);
        verify(mockCollector).collect("test");
    }

    private HttpRequest buildLogHttpRequest(String content) throws UnsupportedEncodingException {
        BasicHttpEntityEnclosingRequest request = new BasicHttpEntityEnclosingRequest("POST", "/log");
        BasicHttpEntity entity = new BasicHttpEntity();
        entity.setContent(new ByteArrayInputStream(content.getBytes("UTF-8")));
        request.setEntity(entity);
        return request;
    }
}
