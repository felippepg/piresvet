package com.piresvet.core.domain.valueobjects;

import com.piresvet.core.exception.InvalidCpfException;

import java.util.regex.Pattern;

public class Cpf {
    private static final Pattern CPF_PATTERN = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    private final String cpf;

    public Cpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()){
            throw new InvalidCpfException("CPF não pode ser nulo!");
        }
        if (!CPF_PATTERN.matcher(cpf).matches()) throw new InvalidCpfException("Formato do CPF inválido");

        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }
}
