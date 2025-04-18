package com.piresvet.adapters.inbound.advice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.piresvet.adapters.inbound.dtos.RestErrorMessage;
import com.piresvet.core.exception.*;

import org.springframework.http.*;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidCrmvException.class)
    private ResponseEntity<RestErrorMessage>invalidCrmvHandler(InvalidCrmvException exception) {
        var response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(InvalidCpfException.class)
    private ResponseEntity<RestErrorMessage>invalidCpfHandler(InvalidCpfException exception) {
        var response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(InvalidUsernameException.class)
    private ResponseEntity<RestErrorMessage>invalidNameHandler(InvalidUsernameException exception) {
        var response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(VetNotFoundException.class)
    private ResponseEntity<RestErrorMessage>noSuchVetException(VetNotFoundException exception) {
        var response = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(PetOwnerNotFoundException.class)
    private ResponseEntity<RestErrorMessage>noSuchPetOwnerException(PetOwnerNotFoundException exception) {
        var response = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(PetOwnerAlreadyExistsException.class)
    private ResponseEntity<RestErrorMessage>alreadyExistsPetOwnerException(PetOwnerAlreadyExistsException exception) {
        var response = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(VetAlreadyExistsException.class)
    private ResponseEntity<RestErrorMessage>alreadyExistsVetException(VetAlreadyExistsException exception) {
        var response = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(InvalidPetException.class)
    private ResponseEntity<RestErrorMessage>invalidPetException(InvalidPetException exception) {
        var response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(PetNotFoundException.class)
    private ResponseEntity<RestErrorMessage>petNotFoundException(PetNotFoundException exception) {
        var response = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidAppointmentsStructureException.class)
    private ResponseEntity<RestErrorMessage>invalidAppointmentStructure(InvalidAppointmentsStructureException exception) {
        var response = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(InvalidAppointmentsException.class)
    private ResponseEntity<RestErrorMessage>invalidAppointment(InvalidAppointmentsException exception) {
        var response = new RestErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    private ResponseEntity<RestErrorMessage>appointmentNotFoundException(AppointmentNotFoundException exception) {
        var response = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException cause = (InvalidFormatException) ex.getCause();

            String invalidValue = cause.getValue().toString();
            String enumName = cause.getTargetType().getSimpleName();

            String message = String.format(ex.getMessage(),
                    invalidValue, enumName);

            var response = new RestErrorMessage(HttpStatus.BAD_REQUEST, message);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        var genericResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, "Failed to read request.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericResponse);
    }


}
