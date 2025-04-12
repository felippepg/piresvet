package com.piresvet.useCaseImplementation.Vet;

import com.piresvet.core.domain.Vet;
import com.piresvet.core.exception.VetAlreadyExistsException;
import com.piresvet.gatewayContracts.Vet.CreateVetGateway;
import com.piresvet.gatewayContracts.Vet.FindVetGateway;
import com.piresvet.useCaseContracts.Vet.CreateVetUseCase;

public class CreateVetUseCaseImpl implements CreateVetUseCase {

    private final CreateVetGateway createVetGateway;
    private final FindVetGateway findVetGateway;

    public CreateVetUseCaseImpl(CreateVetGateway createVetGateway, FindVetGateway findVetGateway) {
        this.createVetGateway = createVetGateway;
        this.findVetGateway = findVetGateway;
    }

    @Override
    public Vet create(Vet vet) {
        var existed = findVetGateway.findByCrm(vet.getCrmv());
        if(existed.isPresent()) {
            throw new VetAlreadyExistsException("Veterinário já cadastrado!");
        }
        return createVetGateway.create(vet);
    }
}
