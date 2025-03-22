package com.piresvet.adapters.outbound.service.Vet;

import com.piresvet.core.exception.VetNotFoundException;
import com.piresvet.dataMapper.VetMapper;
import com.piresvet.gatewayContracts.Vet.DeleteVetGateway;
import com.piresvet.persistence.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteVetGatewayImplementation implements DeleteVetGateway {
    private final VetRepository repository;
    @Override
    public void delete(UUID id) {
        var vet = repository.findById(id).orElseThrow(
                () -> new VetNotFoundException("Veterinário não encontrado"));
        repository.delete(vet);
    }
}
