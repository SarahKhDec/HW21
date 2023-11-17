package org.example.HW21.exceptions.subservice;

public class SubServiceNotFoundException extends RuntimeException {
    public SubServiceNotFoundException(String message) {
        super(message);
    }
}
