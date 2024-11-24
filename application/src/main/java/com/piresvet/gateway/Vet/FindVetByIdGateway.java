package com.piresvet.gateway.Vet;

import com.piresvet.core.domain.Vet;

import java.util.Optional;
import java.util.UUID;

public interface FindVetByIdGateway {
    Optional<Vet> find(UUID id);
}
