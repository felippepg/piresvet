package com.piresvet.dataMapper;

import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerRequest;
import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerResponse;
import com.piresvet.core.domain.PetOwner;
import com.piresvet.core.factory.PetOwnerFactory;
import com.piresvet.dataModel.PetOwnerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PetOwnerMapper {
    private final PetOwnerFactory factory;
    public PetOwner toDomain(PetOwnerRequest request) {
        return factory.create(request.firstname(), request.lastname(), request.cpf());
    }

    public PetOwner toDomain(PetOwnerEntity entity) {
        return factory.create(entity.getId(), entity.getFirstname(), entity.getLastname(), entity.getCpf());
    }

    public PetOwnerEntity toEntity(PetOwner owner) {
        return PetOwnerEntity.builder()
                .firstname(owner.getFirstname())
                .lastname(owner.getLastname())
                .cpf(owner.getCpf().getCpf())
                .build();
    }

    public PetOwnerResponse toResponse(PetOwner petOwner) {
        return new PetOwnerResponse(petOwner.getId(), petOwner.getFirstname(), petOwner.getLastname(), petOwner.getCpf().getCpf());
    }

    public PetOwnerEntity toEntityWithId(PetOwner owner) {
        return PetOwnerEntity.builder()
                .id(owner.getId())
                .firstname(owner.getFirstname())
                .lastname(owner.getLastname())
                .cpf(owner.getCpf().getCpf())
                .build();
    }
}
