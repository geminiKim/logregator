package io.logregator.config.component;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ComponentConfig {
    private ComponentType type;
    private Map<String, Object> config;

    private ComponentConfig() {
    }

    public ComponentConfig(ComponentType type) {
        this.type = type;
        this.config = Maps.newHashMap();
    }

    private  <T> T getConfigValue(String key, Class<T> clazz) {
        return (T) config.get(key);
    }
    public String getConfigString(String key) {
        return getConfigValue(key, String.class);
    }
    public int getConfigInt(String key) {
        return getConfigValue(key, Integer.class);
    }

    public void addConfig(String key, Object value) {
        config.put(key, value);
    }
}
