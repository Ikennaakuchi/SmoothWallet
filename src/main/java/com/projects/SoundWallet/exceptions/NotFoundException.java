package com.projects.SoundWallet.exceptions;

public class NotFoundException extends RuntimeException{

    private String message;

    public NotFoundException() {
        super();
        this.message = "Not Found";
    }

    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
