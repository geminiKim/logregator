package io.logregator.config;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ConfigLoaderTest {

    @Test
    public void testShouldBeLoadConfig() {
        LogregatorConfig config = ConfigLoader.load();
        assertThat(config.getAggregator(), is(notNullValue()));
        assertThat(config.getTransporter(), is(notNullValue()));
    }
}