package com.piresvet.gateway.Vet;

import com.piresvet.core.domain.Vet;

import java.util.Optional;


public interface FindVetByCrmvGateway {
    Optional<Vet> find(String crmv);
}
