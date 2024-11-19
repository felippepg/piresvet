package com.piresvet.core.validation;

import java.util.regex.Pattern;

public class CpfValidator implements Validator {
    private static final Pattern CPF_PATTERN = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");

    @Override
    public void validate(String cpf) {
        if (cpf == null) throw new IllegalArgumentException("CPF não pode ser nulo!");
        if (!CPF_PATTERN.matcher(cpf).matches()) throw new IllegalArgumentException("Formato do CPF inválido");
    }
}
