package io.logregator.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Config {
    private ConfigDetail listener;
    private ConfigDetail sender;
}
