package io.logregator.config;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Config {
    private ComponentType type;
    private Map<String, Object> config;

    private Config() {
    }

    public Config(ComponentType type) {
        this.type = type;
        this.config = Maps.newHashMap();
    }

    private  <T> T getConfigValue(String key, Class<T> clazz) {
        return (T) config.get(key);
    }
    public String getConfigString(String key) {
        return getConfigValue(key, String.class);
    }
    public Integer getConfigInt(String key) {
        return getConfigValue(key, Integer.class);
    }

    public void addConfig(String key, Object value) {
        config.put(key, value);
    }
}
