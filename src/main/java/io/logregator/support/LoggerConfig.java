package io.logregator.support;

import io.logregator.config.LogregatorConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.lang.management.ManagementFactory;

@Slf4j
public class LoggerConfig {
    public static void initialize(LogregatorConfig config) {
        try {
            String processId = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
            MDC.put("logName", processId + "-" +config.getAggregator().getType() + "-" + config.getTransporter().getType());
        } catch (Exception e) {
            MDC.put("logName", "UNKNOWN-" +config.getAggregator().getType() + "-" + config.getTransporter().getType());
        }
    }
}
