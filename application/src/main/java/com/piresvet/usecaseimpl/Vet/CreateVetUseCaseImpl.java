package com.piresvet.usecaseimpl.Vet;

import com.piresvet.core.domain.Vet;
import com.piresvet.gateway.Vet.CreateVetGateway;
import com.piresvet.usecase.Vet.CreateVetUseCase;

public class CreateVetUseCaseImpl implements CreateVetUseCase {

    private final CreateVetGateway createVetGateway;

    public CreateVetUseCaseImpl(CreateVetGateway createVetGateway) {
        this.createVetGateway = createVetGateway;
    }

    @Override
    public void create(Vet vet) {
        createVetGateway.create(vet);
    }
}
