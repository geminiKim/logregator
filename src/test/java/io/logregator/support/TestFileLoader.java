package io.logregator.support;

import com.google.common.io.Resources;

import java.io.File;
import java.io.InputStream;

public class TestFileLoader {
    public static File read(String path) {
        return new File(Resources.getResource(path).getPath());
    }
    public static InputStream getInputStream(String path) {
        return ClassLoader.class.getResourceAsStream(path);
    }
}
