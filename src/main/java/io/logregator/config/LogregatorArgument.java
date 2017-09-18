package io.logregator.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class LogregatorArgument {
    private String configName = "./config/config.json";

    public LogregatorArgument(String... args) {
        if(args.length == 0) return;
        try {
            configName = args[0];
        } catch (Exception e) {
            log.warn("Illegal config file name, will configured 'config.json'");
        }
    }
}
