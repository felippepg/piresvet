package com.piresvet.dataMapper;

import com.piresvet.adapters.inbound.dtos.Pet.PetRequest;
import com.piresvet.adapters.inbound.dtos.Pet.PetResponse;
import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerResponse;
import com.piresvet.core.domain.Pet;
import com.piresvet.core.domain.PetOwner;
import com.piresvet.dataModel.PetEntity;
import com.piresvet.dataModel.PetOwnerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class PetMapper {

    private final PetOwnerMapper petOwnerMapper;

    public PetEntity toEntity(Pet pet, PetOwnerEntity owner) {
        return PetEntity.builder()
                .name(pet.getName())
                .age(pet.getAge())
                .size(pet.getSize())
                .petOwner(owner)
                .species(pet.getSpecies())
                .createdAt(pet.getCreatedAt())
                .updatedAt(pet.getUpdatedAt())
                .build();
    }

    public Pet toDomain(PetEntity entity, PetOwner owner) {
       return new Pet(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                owner,
                entity.getSpecies(),
                entity.getSize()
                );
    }

    public Pet toDomain(PetRequest request, PetOwner owner) {
        return new Pet(
                request.name(),
                request.age(),
                null,
                null,
                owner,
                request.species(),
                request.size()
        );
    }

    public PetResponse toResponse(Pet pet, PetOwner owner) {
        var petOwnerResponse = petOwnerMapper.toResponse(owner);
        return new PetResponse(
                pet.getId(),
                pet.getName(),
                pet.getAge(),
                pet.getSize(),
                pet.getSpecies(),
                pet.getCreatedAt(),
                pet.getUpdatedAt(),
                petOwnerResponse
        );
    }
}
