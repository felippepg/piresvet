package com.piresvet.core.domain.valueobjects;

import com.piresvet.core.exception.InvalidCrmvException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrmvTest {
    @Test
    @DisplayName("Should create Crmv with valid params")
    public void shouldCreateCrmv() {
        var crmv = new Crmv("12345/SP");

        assertEquals("12345/SP", crmv.getCrmv());
    }

    @Test
    @DisplayName("Should not create Crmv with invalid params")
    public void shouldNotCreateCrmvWithInvalidParams() {
        Exception exception = assertThrows(InvalidCrmvException.class, () -> new Crmv("123"));

        assertEquals("Formato de CRMV inválido. Exemplo de formato correto: 12345/SP", exception.getMessage());
    }

    @Test
    @DisplayName("Should not create Crmv with null params")
    public void shouldNotCreateCrmvWithNullParams() {
        Exception exception = assertThrows(InvalidCrmvException.class, () -> new Crmv(null));

        assertEquals("CRMV não pode ser vazio", exception.getMessage());
    }
}