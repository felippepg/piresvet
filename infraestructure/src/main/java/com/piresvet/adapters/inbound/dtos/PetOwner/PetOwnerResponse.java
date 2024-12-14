package com.piresvet.adapters.inbound.dtos.PetOwner;

import java.util.UUID;

public record PetOwnerResponse(UUID id, String firstname, String lastname, String cpf) {
}
