package com.piresvet.adapters.service.Pet;

import com.piresvet.core.domain.Pet;
import com.piresvet.core.exception.PetOwnerNotFoundException;
import com.piresvet.dataMapper.PetMapper;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.dataModel.PetEntity;
import com.piresvet.gatewayContracts.Pet.FindPetsGateway;
import com.piresvet.persistence.PetOwnerRepository;
import com.piresvet.persistence.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindPetGatewayImplementation implements FindPetsGateway {
    private final PetRepository petRepository;
    private final PetOwnerRepository petOwnerRepository;
    private final PetMapper petMapper;
    private final PetOwnerMapper petOwnerMapper;

    @Override
    public List<Pet> findByPetOwnerCpf(String cpf) {
        var ownerEntity = petOwnerRepository.findByCpf(cpf);
        var owner = petOwnerMapper.toDomain(ownerEntity.get());
        var petEntities = petRepository.findByPetOwnerCpf(cpf);

        return petEntities.stream().map(petEntity -> petMapper.toDomain(petEntity, owner))
                .collect(Collectors.toList());
    }

    @Override
    public List<Pet> findAllPets() {
        var petsEntity = petRepository.findAll();
        return petsEntity.stream()
                .map(petEntity -> petMapper.toDomain(petEntity, petOwnerMapper.toDomain(petEntity.getPetOwner())))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Pet> findPetById(UUID id) {
        return petRepository.findById(id)
                .map(petEntity -> petMapper.toDomain(petEntity, petOwnerMapper.toDomain(petEntity.getPetOwner())));
    }

}
