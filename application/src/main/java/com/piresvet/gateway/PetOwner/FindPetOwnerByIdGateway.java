package com.piresvet.gateway.PetOwner;

import com.piresvet.core.domain.PetOwner;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

public interface FindPetOwnerByIdGateway {
    Optional<PetOwner> find(UUID id);
}
