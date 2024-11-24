package com.piresvet.core.domain.valueobjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {
    @Test
    @DisplayName("Should create a name with valid params")
    public void shouldCreateNameWithValidParams() {
        var firstname = new Name("John");

        assertEquals("John", firstname.getName());
    }

    @Test
    @DisplayName("Should not create a name with unless 3 charactes")
    public void shouldNotCreateNameWithInvalidParams() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Name("Ba"));
        assertEquals("Campo precisa no mínimo de 3 caracteres", exception.getMessage());
    }

    @Test
    @DisplayName("Should not create a name with null params")
    public void shouldNotCreateNameWithNullParams() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Name(null));
        assertEquals("Nome não pode ser vazio ou nulo", exception.getMessage());
    }


}