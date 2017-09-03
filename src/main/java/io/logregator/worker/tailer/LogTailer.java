package io.logregator.worker.tailer;

import io.logregator.listener.tailer.LogTailerListener;
import io.logregator.worker.Worker;
import org.apache.commons.io.input.Tailer;

import java.io.File;

public class LogTailer implements Worker {
    private final LogTailerListener listener;
    private Tailer tailer;
    private boolean work;

    public LogTailer(LogTailerListener listener) {
        this.listener = listener;
        this.work = false;
    }

    public void start() {
        if(work == true) return;
        tailer = Tailer.create(new File(listener.getPath()), listener, 100, true);
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
