package com.piresvet.adapters.inbound.dtos;

import org.springframework.http.HttpStatus;

public record RestErrorMessage(HttpStatus status, String message) {
}
