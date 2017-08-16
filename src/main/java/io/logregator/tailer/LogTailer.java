package io.logregator.tailer;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;

import java.io.File;

public class LogTailer {
    private final TailerListener listener;
    private Tailer tailer;
    private boolean work;

    public LogTailer(TailerListener listener) {
        this.listener = listener;
        this.work = false;
    }

    public void tail(String path) {
        if(work == true) return;
        tailer = Tailer.create(new File(path), listener, 100, true);
        work = true;
    }

    public void stop() {
        if(work == false) return;
        tailer.stop();
        work = false;
    }

    public boolean isWork() {
        return work;
    }
}
