package io.logregator.config;

import io.logregator.config.component.ComponentConfig;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Config {
    private ComponentConfig listener;
    private ComponentConfig sender;
}
