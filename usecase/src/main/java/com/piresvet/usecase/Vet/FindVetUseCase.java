package com.piresvet.usecase.Vet;

import com.piresvet.core.domain.Vet;

import java.util.List;
import java.util.UUID;

public interface FindVetUseCase {
    Vet findById(UUID id);
    List<Vet> findByFullname(String firstname, String lastname);

    Vet findByCrm(String crmv);

    List<Vet> findAvailable();

    List<Vet> findAll();

}
