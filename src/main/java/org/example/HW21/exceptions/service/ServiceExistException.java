package org.example.HW21.exceptions.service;

public class ServiceExistException extends RuntimeException {
    public ServiceExistException(String message) {
        super(message);
    }
}
