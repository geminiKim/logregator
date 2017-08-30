package io.logregator.config;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ConfigLoaderTest {

    @Test
    public void testShouldBeLoadConfig() {
        Config config = ConfigLoader.load();
        assertThat(config, is(notNullValue()));
    }
}