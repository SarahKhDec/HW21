package org.example.HW21.exceptions.user;

public class LessCreditException extends RuntimeException {
    public LessCreditException(String message) {
        super(message);
    }
}
