package com.piresvet.usecaseimpl.Vet;

import com.piresvet.core.domain.Vet;
import com.piresvet.gateway.Vet.FindVetGateway;
import com.piresvet.usecase.Vet.FindVetUseCase;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class FindVetUseCaseImpl implements FindVetUseCase {
    private final FindVetGateway findVetGateway;

    public FindVetUseCaseImpl(FindVetGateway findVetGateway) {
        this.findVetGateway = findVetGateway;
    }

    @Override
    public Vet findById(UUID id) {
        var optional = findVetGateway.findById(id);
        return optional.orElseThrow(() -> new NoSuchElementException("Não foi possivel localizar o veteriario"));
    }

    @Override
    public List<Vet> findByFullname(String firstname, String lastname) {
        return findVetGateway.findByFullname(firstname, lastname);
    }

    @Override
    public Vet findByCrm(String crmv) {
        var optional = findVetGateway.findByCrm(crmv);
        return optional.orElseThrow(() -> new NoSuchElementException("Não foi possivel localizar o veterinario"));
    }

    @Override
    public List<Vet> findAvailable() {
        return findVetGateway.findAvailable();
    }

    @Override
    public List<Vet> findAll() {
        return findVetGateway.findAll();
    }
}
