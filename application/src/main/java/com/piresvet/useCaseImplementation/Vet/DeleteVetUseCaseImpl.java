package com.piresvet.useCaseImplementation.Vet;

import com.piresvet.core.exception.VetNotFoundException;
import com.piresvet.gatewayContracts.Vet.DeleteVetGateway;
import com.piresvet.gatewayContracts.Vet.FindVetGateway;
import com.piresvet.useCaseContracts.Vet.DeleteVetUseCase;

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
        this.findVetGateway.findById(id)
                .orElseThrow(() -> new VetNotFoundException("Não foi possivel localizar o veterinário"));
        this.deleteVetGateway.delete(id);
    }
}
