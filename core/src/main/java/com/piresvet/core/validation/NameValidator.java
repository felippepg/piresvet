package com.piresvet.core.validation;

public class NameValidator implements Validator{
    @Override
    public void validate(String name){
        if(name.isEmpty()) {
            throw new IllegalArgumentException("Campo não pode ser vazio");
        }
        if(name.length() < 3) {
            throw new IllegalArgumentException("Campo precisa no mínimo de 3 caracteres");
        }
    }
}
