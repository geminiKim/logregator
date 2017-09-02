package io.logregator.config;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LogregatorConfig {
    private List<Config> logregator;
}
