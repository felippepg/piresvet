package com.piresvet.core.domain.valueobjects;

public class Name {
    private final String name;
    public Name(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo");
        }
        if(name.length() < 3) {
            throw new IllegalArgumentException("Campo precisa no mínimo de 3 caracteres");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
