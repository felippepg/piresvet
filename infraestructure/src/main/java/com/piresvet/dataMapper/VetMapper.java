package com.piresvet.dataMapper;

import com.piresvet.adapters.inbound.dtos.Vet.VetRequest;
import com.piresvet.adapters.inbound.dtos.Vet.VetResponse;
import com.piresvet.core.domain.Vet;
import com.piresvet.core.factory.VetFactory;
import com.piresvet.dataModel.VetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VetMapper {
    private final VetFactory factory;
    public VetEntity toEntity(Vet vet) {
        return VetEntity.builder()
                .firstname(vet.getFirstname())
                .lastname(vet.getLastname())
                .crmv(vet.getCrmv())
                .available(true)
                .build();
    }

    public Vet toDomain(VetEntity entity) {
        return factory.create(entity.getId(), entity.getFirstname(), entity.getLastname(), entity.getCrmv(), entity.getAvailable());
    }

    public Vet toDomain(VetRequest request) {
        return factory.create(request.firstname(), request.lastname(), request.crmv());
    }

    public VetResponse toResponse(Vet vet) {
        return new VetResponse(vet.getId(), vet.getFirstname(), vet.getLastname(), vet.getCrmv(), vet.getAvailable());
    }

    public VetEntity toEntityWithId(Vet vet) {
        return VetEntity.builder()
                .id(vet.getId())
                .firstname(vet.getFirstname())
                .lastname(vet.getLastname())
                .crmv(vet.getCrmv())
                .available(true)
                .build();
    }
}
