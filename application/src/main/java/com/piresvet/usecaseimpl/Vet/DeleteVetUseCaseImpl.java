package com.piresvet.usecaseimpl.Vet;

import com.piresvet.gateway.Vet.DeleteVetGateway;
import com.piresvet.gateway.Vet.FindVetGateway;
import com.piresvet.usecase.Vet.DeleteVetUseCase;
import com.piresvet.usecase.Vet.FindVetUseCase;

import java.util.UUID;

public class DeleteVetUseCaseImpl implements DeleteVetUseCase {
    private final DeleteVetGateway deleteVetGateway;
    private final FindVetGateway findVetGateway;

    public DeleteVetUseCaseImpl(DeleteVetGateway deleteVetGateway, FindVetGateway findVetGateway) {
        this.deleteVetGateway = deleteVetGateway;
        this.findVetGateway = findVetGateway;
    }

    @Override
    public void delete(UUID id) {
        this.findVetGateway.findById(id);
        this.deleteVetGateway.delete(id);
    }
}
