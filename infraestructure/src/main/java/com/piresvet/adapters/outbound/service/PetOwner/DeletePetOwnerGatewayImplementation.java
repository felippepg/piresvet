package com.piresvet.adapters.outbound.service.PetOwner;

import com.piresvet.core.exception.PetOwnerNotFoundException;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.gatewayContracts.PetOwner.DeletePetOwnerGateway;
import com.piresvet.persistence.PetOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class DeletePetOwnerGatewayImplementation implements DeletePetOwnerGateway {
    private final PetOwnerRepository repository;
    private final PetOwnerMapper mapper;
    @Override
    public void delete(UUID id) {
        var petOwner = repository.findById(id).orElseThrow(() -> new PetOwnerNotFoundException("Tutor não encontrado"));
        repository.delete(petOwner);
    }
}
