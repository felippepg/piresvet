package com.piresvet.core.domain.valueobjects;

import com.piresvet.core.exception.InvalidCpfException;
import com.piresvet.core.exception.InvalidCrmvException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {
    @Test
    @DisplayName("Should create Cpf with valid params")
    public void shouldCreateCpfv() {
        var cpf = new Cpf("000.000.000-00");

        assertEquals("000.000.000-00", cpf.getCpf());
    }

    @Test
    @DisplayName("Should not create Cpf with invalid params")
    public void shouldNotCreateCpfWithInvalidParams() {
        Exception exception = assertThrows(InvalidCpfException.class, () -> new Cpf("123"));

        assertEquals("Formato do CPF inválido", exception.getMessage());
    }

    @Test
    @DisplayName("Should not create Cpf with null params")
    public void shouldNotCreateCpfWithNullParams() {
        Exception exception = assertThrows(InvalidCpfException.class, () -> new Cpf(null));

        assertEquals("CPF não pode ser nulo!", exception.getMessage());
    }
}