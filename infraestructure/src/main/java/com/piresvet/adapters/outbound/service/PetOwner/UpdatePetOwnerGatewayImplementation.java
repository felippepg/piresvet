package com.piresvet.adapters.outbound.service.PetOwner;


import com.piresvet.core.domain.PetOwner;
import com.piresvet.core.exception.PetOwnerNotFoundException;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.gatewayContracts.PetOwner.UpdatePetOwnerGateway;
import com.piresvet.persistence.PetOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class UpdatePetOwnerGatewayImplementation implements UpdatePetOwnerGateway {
    private final PetOwnerRepository repository;
    private final PetOwnerMapper mapper;
    @Override
    public PetOwner update(UUID id, PetOwner owner) {
        var actual = repository.findById(id).orElseThrow(() -> new PetOwnerNotFoundException("Tutor não encontrado"));
        if(owner.getFirstname() != null) {
            actual.setFirstname(owner.getFirstname());
        }
        if(owner.getLastname() != null) {
            actual.setLastname(owner.getLastname());
        }
        if(owner.getCpf().getCpf() != null) {
            actual.setCpf(owner.getCpf().getCpf());
        }
        var newPetOwner = repository.save(actual);
        return mapper.toDomain(newPetOwner);
    }
}
