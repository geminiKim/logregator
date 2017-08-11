package io.logregator;

import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import org.apache.commons.io.input.TailerListenerAdapter;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

public class TailerTest {

    @Test
    public void testTailer() throws Exception {
        TailerListener listener = new MyTailerListener();
        File file = new File("/Workspace/geminikim/logregator/src/test/resources/data/test.txt");

        Tailer tailer = Tailer.create(file, listener, 1000, true);

        new Scanner(System.in).nextLine();
    }

    public class MyTailerListener extends TailerListenerAdapter {

        private final PublishSubject<String> subject;

        public MyTailerListener() {
            subject = PublishSubject.create();
            Disposable disposable = subject.subscribe(values -> System.out.println(values));
        }

        public void handle(String line) {
            subject.onNext(line);
        }
    }
}
