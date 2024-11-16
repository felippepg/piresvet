package com.piresvet.core.factory;

import com.piresvet.core.exception.InvalidCrmvException;
import com.piresvet.core.validation.NameValidator;
import com.piresvet.core.validation.Validator;
import com.piresvet.core.validation.VetCrmvValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class VetFactoryTest {
    Validator vetCrmvValidator = new VetCrmvValidator();
    Validator nameValidator = new NameValidator();
    @Test
    @DisplayName("Shouldn´t create a Vet with invalid CRVM")
    void createWithInvalidCRMV() {
        var invalidCrmv = "1/SP";
        var factory = new VetFactory(nameValidator, vetCrmvValidator);

        InvalidCrmvException exception = assertThrows(InvalidCrmvException.class, () -> {
            factory.create("john", "dee", invalidCrmv);
        });

        assertEquals("Formato de CRMV inválido. Exemplo de formato correto: 12345/SP", exception.getMessage());

    }

    @Test
    @DisplayName("Shouldn't create a Vet with empty CRMV")
    void createWithEmptyCRMV() {
        var factory = new VetFactory(nameValidator, vetCrmvValidator);

        InvalidCrmvException exception = assertThrows(InvalidCrmvException.class, () -> {
            factory.create("john", "dee", null);
        });

        assertEquals("CRMV não pode ser vazio", exception.getMessage());
    }

    @Test
    @DisplayName("Should create a Vet with valid CRMV")
    void createWithValidCRMV() {
        var factory = new VetFactory(nameValidator, vetCrmvValidator);
        var vet = factory.create("john", "dee", "12345/SP");

        assertNotNull(vet);
        assertEquals("john", vet.getFirstname());
        assertEquals("dee", vet.getLastname());
        assertEquals("12345/SP", vet.getCrmv());
    }

}