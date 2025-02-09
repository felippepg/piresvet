package com.piresvet.core.exception;

public class PetOwnerAlreadyExistsException extends RuntimeException {
    public PetOwnerAlreadyExistsException(String message) {
        super(message);
    }
}
