package org.example.HW21.exceptions.user;

public class UserExistException extends RuntimeException {
    public UserExistException(String message) {
        super(message);
    }
}
