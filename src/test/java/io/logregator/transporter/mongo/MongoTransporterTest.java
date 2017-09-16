package io.logregator.transporter.mongo;

import com.mongodb.client.MongoCollection;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MongoTransporterTest {
    private final MongoCollection mockCollection = mock(MongoCollection.class);
    private MongoTransporter sender;

    @Before
    public void setup() {
        MongoTransporterConfig config = MongoConfigBuilder.aMongoConfig().withCollection(mockCollection).build();
        sender = new MongoTransporter(config);
    }

    @Test
    public void testShouldBeInsertToMongo() {
        sender.transport("{'hello':'world'}");
        verify(mockCollection).insertOne(any());
    }
}