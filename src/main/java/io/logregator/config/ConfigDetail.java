package io.logregator.config;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ConfigDetail {
    private ConfigType type;
    private Map<String, Object> config;
}
