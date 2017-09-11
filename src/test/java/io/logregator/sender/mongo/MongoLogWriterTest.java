package io.logregator.sender.mongo;

import com.mongodb.client.MongoCollection;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MongoLogWriterTest {
    private final MongoCollection mockCollection = mock(MongoCollection.class);

    private MongoLogWriter writer;

    @Before
    public void setup() {
        MongoConfig config = MongoConfigBuilder.aMongoConfig().withCollection(mockCollection).build();
        writer = new MongoLogWriter(config);
    }

    @Test
    public void write() {
        writer.write("{'hello':'world'}");
        verify(mockCollection).insertOne(any());
    }
}