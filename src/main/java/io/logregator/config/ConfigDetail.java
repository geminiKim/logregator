package io.logregator.config;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ConfigDetail {
    private ComponentType type;
    private Map<String, Object> config;

    private ConfigDetail() {
    }

    public ConfigDetail(ComponentType type) {
        this.type = type;
        this.config = Maps.newHashMap();
    }

    public <T> T getConfigValue(String key, Class<T> clazz) {
        return (T) config.get(key);
    }

    public void addConfig(String key, Object value) {
        config.put(key, value);
    }
}
