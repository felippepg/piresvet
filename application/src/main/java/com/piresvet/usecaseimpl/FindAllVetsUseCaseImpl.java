package com.piresvet.usecaseimpl;

import com.piresvet.core.domain.Vet;
import com.piresvet.gateway.FindAllVetsGateway;
import com.piresvet.usecase.Vet.FindAllVetsUseCase;

import java.util.List;

public class FindAllVetsUseCaseImpl implements FindAllVetsUseCase {
    private final FindAllVetsGateway findAllVetsGateway;

    public FindAllVetsUseCaseImpl(FindAllVetsGateway findAllVetsGateway) {
        this.findAllVetsGateway = findAllVetsGateway;
    }

    @Override
    public List<Vet> getVets() {
        return findAllVetsGateway.getVets();
    }
}
