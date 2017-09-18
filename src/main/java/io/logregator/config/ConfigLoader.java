package io.logregator.config;

import com.google.common.base.Charsets;
import io.logregator.support.exception.LogregatorException;
import io.logregator.support.util.JsonUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigLoader {
    public static LogregatorConfig load(LogregatorArgument argument) {
        try {
            String configName = argument.getConfigName();
            Path path = Paths.get(configName);
            return JsonUtils.fromJson(new String(Files.readAllBytes(path), Charsets.UTF_8), LogregatorConfig.class);
        } catch (IOException e) {
            throw new LogregatorException(e);
        }
    }
}
