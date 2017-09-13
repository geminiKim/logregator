package io.logregator.listener.tailer;

import io.logregator.config.component.ComponentConfig;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TailerConfig {
    private String path;

    protected TailerConfig() {
    }

    public TailerConfig(ComponentConfig config) {
        this.path = config.getConfigString("filePath");
    }
}
