package com.piresvet.adapters.inbound.dtos.Vet;


import java.util.UUID;

public record VetResponse(UUID id, String firstname, String lastname, String crmv, Boolean available) {
}
