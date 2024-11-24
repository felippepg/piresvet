package com.piresvet.usecaseimpl.Vet;

import com.piresvet.core.domain.Vet;
import com.piresvet.gateway.Vet.FindAvailableVetsGateway;
import com.piresvet.usecase.Vet.FindAvailableVetsUseCase;

import java.util.List;

public class FindAvailableVetsUseCaseImpl implements FindAvailableVetsUseCase {
    private final FindAvailableVetsGateway findAvailableVetsGateway;

    public FindAvailableVetsUseCaseImpl(FindAvailableVetsGateway findAvailableVetsGateway) {
        this.findAvailableVetsGateway = findAvailableVetsGateway;
    }

    @Override
    public List<Vet> getVets() {
        return findAvailableVetsGateway.getVets();
    }
}
