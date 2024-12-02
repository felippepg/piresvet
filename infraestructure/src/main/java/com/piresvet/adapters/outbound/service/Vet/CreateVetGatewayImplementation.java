package com.piresvet.adapters.outbound.service.Vet;

import com.piresvet.core.domain.Vet;
import com.piresvet.gatewayContracts.Vet.CreateVetGateway;
import com.piresvet.dataMapper.VetMapper;
import com.piresvet.persistence.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateVetGatewayImplementation implements CreateVetGateway {

    private final VetRepository repository;
    private final VetMapper mapper;

    @Override
    public Vet create(Vet vet) {
        var entity = mapper.toEntity(vet);
        var result = repository.save(entity);
        return mapper.toDomain(result);
    }
}
