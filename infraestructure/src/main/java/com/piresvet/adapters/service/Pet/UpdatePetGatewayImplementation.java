package com.piresvet.adapters.service.Pet;

import com.piresvet.core.domain.Pet;
import com.piresvet.dataMapper.PetMapper;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.gatewayContracts.Pet.UpdatePetGateway;
import com.piresvet.persistence.PetOwnerRepository;
import com.piresvet.persistence.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdatePetGatewayImplementation implements UpdatePetGateway {
    private final PetRepository petRepository;
    private final PetOwnerRepository petOwnerRepository;
    private final PetMapper petMapper;
    private final PetOwnerMapper petOwnerMapper;
    @Override
    public Pet update(UUID id, Pet pet) {
        var actual = petRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Pet não encontrado"));
        if(pet.getName() != null) {
            actual.setName(pet.getName());
        }
        if(pet.getAge() != null) {
            actual.setAge(pet.getAge());
        }
        if(pet.getSize() != null) {
            actual.setSize(pet.getSize());
        }
        if(pet.getSpecies() != null) {
            actual.setSpecies(pet.getSpecies());
        }
        if(pet.getPetOwner() != null) {
            var petOwnerEntity = petOwnerMapper.toEntityWithId(pet.getPetOwner());
            actual.setPetOwner(petOwnerEntity);

        }

        var newPet = petRepository.save(actual);
        var owner = petOwnerMapper.toDomain(newPet.getPetOwner());
        return petMapper.toDomain(newPet, owner);
    }
}
