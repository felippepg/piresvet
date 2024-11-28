package com.piresvet.useCaseImplementation.Vet;

import com.piresvet.core.domain.Vet;
import com.piresvet.gatewayContracts.Vet.FindVetGateway;
import com.piresvet.gatewayContracts.Vet.UpdateVetUseGateway;
import com.piresvet.useCaseContracts.Vet.UpdateVetUseCase;

import java.util.UUID;

public class UpdateVetUseCaseImpl implements UpdateVetUseCase {
    private final UpdateVetUseGateway updateVetUseGateway;
    private final FindVetGateway findVetGateway;

    public UpdateVetUseCaseImpl(UpdateVetUseGateway updateVetUseGateway, FindVetGateway findVetGateway) {
        this.updateVetUseGateway = updateVetUseGateway;
        this.findVetGateway = findVetGateway;
    }

    @Override
    public Vet update(UUID id) {
        this.findVetGateway.findById(id);
        return this.updateVetUseGateway.update(id);
    }
}
