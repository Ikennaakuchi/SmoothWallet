package com.projects.SoundWallet.exceptions;

public class ValidationException extends RuntimeException{
    private String message;

    public ValidationException() {
        super();
        this.message = "Validation Failed";
    }

    public ValidationException(String message) {
        super(message);
        this.message = message;
    }
}
