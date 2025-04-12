package com.piresvet.adapters.outbound.service.Vet;

import com.piresvet.adapters.inbound.dtos.Vet.VetResponse;
import com.piresvet.core.domain.Vet;
import com.piresvet.core.exception.VetNotFoundException;
import com.piresvet.dataMapper.VetMapper;
import com.piresvet.gatewayContracts.Vet.UpdateVetUseGateway;
import com.piresvet.persistence.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateVetGatewayImplementation implements UpdateVetUseGateway {
    private final VetRepository repository;
    private final VetMapper mapper;

    @Override
    public Vet update(UUID id, Vet vet) {
        var actual = repository.findById(id).get();

        if(vet.getFirstname() != null) {
            actual.setFirstname(vet.getFirstname());
        }
        if(vet.getLastname() != null) {
            actual.setLastname(vet.getLastname());
        }
        var updatedVet = repository.save(actual);
        return mapper.toDomain(updatedVet);
    }
}
