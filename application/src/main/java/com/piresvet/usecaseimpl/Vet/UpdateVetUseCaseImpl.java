package com.piresvet.usecaseimpl.Vet;

import com.piresvet.core.domain.Vet;
import com.piresvet.gateway.Vet.FindVetByIdGateway;
import com.piresvet.gateway.Vet.UpdateVetUseGateway;
import com.piresvet.usecase.Vet.UpdateVetUseCase;

import java.util.UUID;

public class UpdateVetUseCaseImpl implements UpdateVetUseCase {
    private final UpdateVetUseGateway updateVetUseGateway;
    private final FindVetByIdGateway findVetByIdGateway;

    public UpdateVetUseCaseImpl(UpdateVetUseGateway updateVetUseGateway, FindVetByIdGateway findVetByIdGateway) {
        this.updateVetUseGateway = updateVetUseGateway;
        this.findVetByIdGateway = findVetByIdGateway;
    }

    @Override
    public Vet update(UUID id) {
        this.findVetByIdGateway.find(id);
        return this.updateVetUseGateway.update(id);
    }
}
