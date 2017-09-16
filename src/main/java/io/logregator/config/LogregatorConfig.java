package io.logregator.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogregatorConfig {
    private Config aggregator;
    private Config transporter;
}
