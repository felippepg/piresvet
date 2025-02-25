package com.piresvet.adapters.inbound.dtos.Pet;

import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerRequest;
import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerResponse;
import com.piresvet.core.domain.PetOwner;
import com.piresvet.core.enums.Size;
import com.piresvet.core.enums.Species;

import java.util.Date;
import java.util.UUID;

public record PetResponse(
        UUID id,
        String name,
        Integer age,
        Size size,
        Species species,
        Date createdAt,
        Date updatedAt,
        PetOwnerResponse petOwnerResponse
) {
}
