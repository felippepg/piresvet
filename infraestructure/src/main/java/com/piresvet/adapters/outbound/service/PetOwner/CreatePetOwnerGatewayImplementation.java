package com.piresvet.adapters.outbound.service.PetOwner;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.gatewayContracts.PetOwner.CreatePetOwnerGateway;
import com.piresvet.persistence.PetOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePetOwnerGatewayImplementation implements CreatePetOwnerGateway {
    private final PetOwnerRepository repository;
    private final PetOwnerMapper mapper;
    @Override
    public PetOwner create(PetOwner owner) {
        var entity = mapper.toEntity(owner);
        var result = repository.save(entity);
        return mapper.toDomain(result);
    }
}
