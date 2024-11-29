package org.example.bowling;

import java.util.List;

public class IllegalBowlingArgumentException extends IllegalArgumentException {
    private final List<String> errorMessages;

    // Constructor that accepts a list of error messages
    public IllegalBowlingArgumentException(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    // Get the error messages
    public List<String> getErrorMessages() {
        return errorMessages;
    }
}