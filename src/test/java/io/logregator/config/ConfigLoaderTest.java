package io.logregator.config;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigLoaderTest {

    @Test
    public void testShouldBeLoadConfig() {
        LogregatorConfig config = ConfigLoader.load();
        assertThat(config.getConfigs().size(), is(greaterThan(0)));
    }
}