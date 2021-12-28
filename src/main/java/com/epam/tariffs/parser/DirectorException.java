package com.epam.tariffs.parser;

public class DirectorException extends Exception {
    public DirectorException() {
    }

    public DirectorException(String message) {
        super(message);
    }

    public DirectorException(String message, Throwable cause) {
        super(message, cause);
    }

    public DirectorException(Throwable cause) {
        super(cause);
    }

}
