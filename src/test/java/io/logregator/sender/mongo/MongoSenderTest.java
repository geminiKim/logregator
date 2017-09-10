package io.logregator.sender.mongo;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MongoSenderTest {
    private final MongoLogWriter mockMongoLogWriter = mock(MongoLogWriter.class);
    private MongoSender sender;

    @Before
    public void setup() {
        sender = new MongoSender(mockMongoLogWriter);
    }

    @Test
    public void testShouldBeWriteLogToMongoDB() {
        String message = "{'hello':'world'}";
        sender.send(message);
        verify(mockMongoLogWriter).write(message);
    }
}