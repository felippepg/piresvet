package com.piresvet.core.factory;

import static org.mockito.Mockito.*;
import com.piresvet.core.exception.InvalidCrmvException;
import com.piresvet.core.validation.NameValidator;
import com.piresvet.core.validation.Validator;
import com.piresvet.core.validation.VetCrmvValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VetFactoryTest {
    Validator vetCrmvValidator;
    Validator nameValidator;
    VetFactory factory;
    @BeforeEach
    public void setup() {
        vetCrmvValidator = mock(VetCrmvValidator.class);
        nameValidator = mock(NameValidator.class);

        factory = new VetFactory(nameValidator, vetCrmvValidator);
    }

    @Test
    @DisplayName("Should create a Vet with valid CRMV")
    void createWithValidCRMV() {
        var firstname = "john";
        var lastname = "dee";
        var crmv = "12345/SP";
        var vet = factory.create(firstname, lastname, crmv);

        doNothing().when(vetCrmvValidator).validate(crmv);
        doNothing().when(nameValidator).validate(firstname);
        doNothing().when(nameValidator).validate(lastname);

        assertNotNull(vet);
        assertEquals("john", vet.getFirstname());
        assertEquals("dee", vet.getLastname());
        assertEquals("12345/SP", vet.getCrmv());
    }

    @Test
    @DisplayName("Should not create a Vet with invalid CRVM")
    void createWithInvalidCRMV() {
        var firstname = "john";
        var lastname = "dee";
        var crmv = "aa0";

        doNothing().when(nameValidator).validate(firstname);
        doNothing().when(nameValidator).validate(lastname);
        doThrow(new InvalidCrmvException("Formato de CRMV inválido. Exemplo de formato correto: 12345/SP"))
                .when(vetCrmvValidator).validate(crmv);

        var exception = assertThrows(InvalidCrmvException.class, () -> {
            factory.create(firstname, lastname, crmv);
        });

        assertEquals("Formato de CRMV inválido. Exemplo de formato correto: 12345/SP", exception.getMessage());

    }

    @Test
    @DisplayName("Should not create a Vet with empty CRMV")
    void createWithEmptyCRMV() {
        var firstname = "john";
        var lastname = "dee";

        doNothing().when(nameValidator).validate(firstname);
        doNothing().when(nameValidator).validate(lastname);
        doThrow(new InvalidCrmvException("CRMV não pode ser vazio"))
                .when(vetCrmvValidator).validate(null);

        assertThrows(InvalidCrmvException.class, () -> {
            factory.create(firstname, lastname, null);
        });

    }

    @Test
    @DisplayName("Should not create a Vet with invalid name")
    void createWithInvalidName() {
        var firstname = "a";
        var lastname = "dee";
        var crmv = "12345/SP";

        doThrow(new InvalidCrmvException("CRMV não pode ser vazio"))
                .when(nameValidator).validate(firstname);
        doNothing().when(nameValidator).validate(lastname);
        doNothing().when(vetCrmvValidator).validate(crmv);

    }

}