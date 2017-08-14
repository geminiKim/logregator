package io.logregator.support;

import com.google.common.io.Resources;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class TestFileLoader {
    public static File load(String path) {
        URL resource = Resources.getResource(path);
        return new File(resource.getPath());
    }
    public static InputStream loadInputStream(String path) {
        return ClassLoader.class.getResourceAsStream(path);
    }
}
