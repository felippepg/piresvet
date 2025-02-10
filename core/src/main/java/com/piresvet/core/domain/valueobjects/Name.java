package com.piresvet.core.domain.valueobjects;

import com.piresvet.core.exception.InvalidUsernameException;

public class Name {
    private final String name;
    public Name(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidUsernameException("Nome não pode ser vazio ou nulo");
        }
        if(name.length() < 3) {
            throw new InvalidUsernameException("Campo precisa no mínimo de 3 caracteres");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
