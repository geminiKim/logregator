package io.logregator.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ConfigLoaderTest {

    @Test
    public void testShouldBeLoadConfig() {
        ObjectMapper mapper = new ObjectMapper();
        Config config = new ConfigLoader(mapper).load();
        assertThat(config, is(notNullValue()));
    }
}