package io.logregator.support;

import java.io.FileWriter;

public class ConcurrentTestFileWriter {

    public static void writeTestData(String path, String message, int loop) {
        writeTestData(path, message, loop, 1);
    }

    public static void writeTestData(String path, String message, int loop, long delay) {
        ((Runnable) () -> {
            try {
                FileWriter writer = new FileWriter(TestFileLoader.load(path), true);
                for (int i = 0; i < loop; i++) {
                    writer.write(i + " : " + message + "\n");
                    writer.flush();
                }
                Thread.sleep(delay);
            } catch (Exception e) {
            }
        }).run();
    }
}