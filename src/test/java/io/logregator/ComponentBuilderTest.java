package io.logregator;

import com.google.common.collect.Lists;
import io.logregator.config.ConfigBuilder;
import io.logregator.config.LogregatorConfig;
import io.logregator.config.LogregatorConfigBuilder;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ComponentBuilderTest {
    private final ConfigBuilder configBuilder = ConfigBuilder.aConfig();
    private final LogregatorConfigBuilder logregatorConfigBuilder = LogregatorConfigBuilder.aLogregatorConfig();

    @Test
    public void testShouldBeBuildComponents() {
        LogregatorConfig config = logregatorConfigBuilder.withConfigs(Lists.newArrayList(configBuilder.build()))
                                                            .build();

        List<Component> components = ComponentBuilder.build(config);
        assertThat(components.size(), is(1));
    }
}