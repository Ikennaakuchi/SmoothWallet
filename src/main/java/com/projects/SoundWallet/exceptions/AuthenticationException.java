package com.projects.SoundWallet.exceptions;

public class AuthenticationException extends RuntimeException{
    private String message;

    public AuthenticationException() {
        super();
        this.message = "Authentication Failed";
    }

    public AuthenticationException(String message) {
        super(message);
        this.message = message;
    }
}
