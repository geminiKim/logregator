package io.logregator.listener.tailer;

import io.logregator.config.Config;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TailerConfig {
    private String path;

    protected TailerConfig() {
    }

    public TailerConfig(Config config) {
        this.path = config.getConfigString("filePath");
    }
}
