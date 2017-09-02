package io.logregator.config;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import io.logregator.support.exception.LogregatorException;
import io.logregator.support.util.JsonUtils;

import java.io.IOException;
import java.net.URL;

public class ConfigLoader {
    public static LogregatorConfig load() {
        try {
            URL url = Resources.getResource("config.json");
            return JsonUtils.fromJson(Resources.toString(url, Charsets.UTF_8), LogregatorConfig.class);
        } catch (IOException e) {
            throw new LogregatorException(e);
        }
    }
}
