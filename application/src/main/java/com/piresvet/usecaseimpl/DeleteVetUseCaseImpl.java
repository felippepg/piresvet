package com.piresvet.usecaseimpl;

import com.piresvet.gateway.DeleteVetGateway;
import com.piresvet.usecase.Vet.DeleteVetUseCase;
import com.piresvet.usecase.Vet.FindVetByCrmvUseCase;
import com.piresvet.usecase.Vet.FindVetByIdUseCase;

import java.util.UUID;

public class DeleteVetUseCaseImpl implements DeleteVetUseCase {
    private final DeleteVetGateway deleteVetGateway;
    private final FindVetByIdUseCase findVetByIdUseCase;

    public DeleteVetUseCaseImpl(DeleteVetGateway deleteVetGateway, FindVetByIdUseCase findVetByIdUseCase) {
        this.deleteVetGateway = deleteVetGateway;
        this.findVetByIdUseCase = findVetByIdUseCase;
    }

    @Override
    public void delete(UUID id) {
        this.findVetByIdUseCase.find(id);
        this.deleteVetGateway.delete(id);
    }
}
