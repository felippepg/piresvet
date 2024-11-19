package com.piresvet.core.factory;

import static org.mockito.Mockito.*;

import com.piresvet.core.validation.CpfValidator;
import com.piresvet.core.validation.NameValidator;
import com.piresvet.core.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetOwnerFactoryTest {
    Validator nameValidator;
    Validator cpfValidator;
    PetOwnerFactory factory;

    @BeforeEach
    public void setup() {
        nameValidator = mock(NameValidator.class);
        cpfValidator = mock(CpfValidator.class);

        factory = new PetOwnerFactory(nameValidator, cpfValidator);
    }

    @Test
    @DisplayName("Should create a pet owner with valid params")
    void createWithValidParams() {
        var firstname = "john";
        var lastname = "dee";
        var cpf = "000.000.000-00";
        var owner = factory.create(firstname, lastname, cpf);

        doNothing().when(nameValidator).validate(firstname);
        doNothing().when(nameValidator).validate(lastname);
        doNothing().when(cpfValidator).validate(cpf);

        assertNotNull(owner);
        assertEquals("john", owner.getFirstname());
        assertEquals("dee", owner.getLastname());
        assertEquals("000.000.000-00", owner.getCpf());

    }

    @Test
    @DisplayName("Should not create a pet owner with invalid cpf")
    void createWithInvalidCpf() {
        var firstname = "john";
        var lastname = "dee";
        var cpf = "000.00000";

        doNothing().when(nameValidator).validate(lastname);
        doNothing().when(nameValidator).validate(firstname);
        doThrow(new IllegalArgumentException("Formato do CPF inválido"))
                .when(cpfValidator).validate(cpf);

        var exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.create(firstname, lastname, cpf);
        });
        assertEquals("Formato do CPF inválido", exception.getMessage());

    }

    @Test
    @DisplayName("Should not create a pet owner with empty cpf")
    void createWithEmptyCpf() {
        var firstname = "john";
        var lastname = "dee";

        doNothing().when(nameValidator).validate(lastname);
        doNothing().when(nameValidator).validate(firstname);
        doThrow(new IllegalArgumentException("CPF não pode ser nulo!"))
                .when(cpfValidator).validate(null);


        var exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.create(firstname, lastname, null);
        });
        assertEquals("CPF não pode ser nulo!", exception.getMessage());

    }

    @Test
    @DisplayName("Should not create a pet owner with invalid name")
    void createWithInvalidName() {
        var firstname = "a";
        var lastname = "dee";
        var cpf = "000.00000";

        doNothing().when(nameValidator).validate(firstname);
        doNothing().when(nameValidator).validate(lastname);
        doThrow(new IllegalArgumentException("Campo precisa no mínimo de 3 caracteres"))
                .when(cpfValidator).validate(cpf);

        var exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.create(firstname, lastname, cpf);
        });

        assertEquals("Campo precisa no mínimo de 3 caracteres", exception.getMessage());
    }
}