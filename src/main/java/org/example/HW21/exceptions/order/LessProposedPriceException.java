package org.example.HW21.exceptions.order;

public class LessProposedPriceException extends RuntimeException {
    public LessProposedPriceException(String message) {
        super(message);
    }
}
