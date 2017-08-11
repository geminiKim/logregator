package io.logregator;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import org.apache.commons.io.input.TailerListenerAdapter;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TailerTest {

    @Test
    public void testTailer() throws IOException {
        TailerListener listener = new MyTailerListener();
        File file = new File("/Workspace/geminikim/logregator/src/test/resources/data/test.txt");

        Tailer.create(file, listener, 1000);
    }

    public class MyTailerListener extends TailerListenerAdapter {
        public void handle(String line) {
            System.out.println(line);
        }
    }
}
