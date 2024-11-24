package com.piresvet.usecaseimpl.Vet;

import com.piresvet.core.domain.Vet;
import com.piresvet.gateway.Vet.FindVetByIdGateway;
import com.piresvet.usecase.Vet.FindVetByIdUseCase;

import java.util.NoSuchElementException;
import java.util.UUID;

public class FindVetByIdUseCaseImpl implements FindVetByIdUseCase {
    private final FindVetByIdGateway findVetByIdGateway;

    public FindVetByIdUseCaseImpl(FindVetByIdGateway findVetByIdGateway) {
        this.findVetByIdGateway = findVetByIdGateway;
    }

    @Override
    public Vet find(UUID id) {
        var optional = findVetByIdGateway.find(id);
        return optional.orElseThrow(() -> new NoSuchElementException("Item não encontrado"));
    }

}
