package io.logregator.collector.tailer;

import io.logregator.config.Config;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TailCollectorConfig {
    private String path;

    protected TailCollectorConfig() {
    }

    public TailCollectorConfig(Config config) {
        this.path = config.getConfigString("filePath");
    }
}
