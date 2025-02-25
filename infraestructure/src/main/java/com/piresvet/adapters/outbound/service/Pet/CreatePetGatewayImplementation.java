package com.piresvet.adapters.outbound.service.Pet;

import com.piresvet.core.domain.Pet;
import com.piresvet.dataMapper.PetMapper;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.gatewayContracts.Pet.CreatePetGateway;
import com.piresvet.persistence.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePetGatewayImplementation implements CreatePetGateway {
    private final PetRepository repository;
    private final PetMapper petMapper;
    private final PetOwnerMapper petOwnerMapper;
    @Override
    public Pet create(Pet pet) {
        var petOwnerEntity = petOwnerMapper.toEntityWithId(pet.getPetOwner());
        var petEntity = petMapper.toEntity(pet, petOwnerEntity);

        var petOwnerDomain = petOwnerMapper.toDomain(petEntity.getPetOwner());
        repository.save(petEntity);
        return petMapper.toDomain(petEntity, petOwnerDomain);
    }
}
