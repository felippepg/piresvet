package com.piresvet.useCaseImplementation.Vet;

import com.piresvet.core.domain.Vet;
import com.piresvet.gatewayContracts.Vet.CreateVetGateway;
import com.piresvet.useCaseContracts.Vet.CreateVetUseCase;

public class CreateVetUseCaseImpl implements CreateVetUseCase {

    private final CreateVetGateway createVetGateway;

    public CreateVetUseCaseImpl(CreateVetGateway createVetGateway) {
        this.createVetGateway = createVetGateway;
    }

    @Override
    public Vet create(Vet vet) {
        return createVetGateway.create(vet);
    }
}
