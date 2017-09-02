package io.logregator.support.exception;

public class LogregatorException extends RuntimeException {
    public LogregatorException() {
    }

    public LogregatorException(String message) {
        super(message);
    }

    public LogregatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogregatorException(Throwable cause) {
        super(cause);
    }
}
