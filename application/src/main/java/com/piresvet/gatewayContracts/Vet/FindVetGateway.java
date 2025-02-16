package com.piresvet.gatewayContracts.Vet;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.core.domain.Vet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FindVetGateway {
    Optional<Vet> findById(UUID id);
    List<Vet> findByFullname(String firstname, String lastname);

    Optional<Vet> findByCrm(String crmv);

    List<Vet> findAvailable();

    List<Vet> findAll();

    List<Vet> findByName(String firstname);


}
