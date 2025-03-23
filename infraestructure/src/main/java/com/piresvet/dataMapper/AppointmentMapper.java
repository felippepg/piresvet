package com.piresvet.dataMapper;

import com.piresvet.adapters.inbound.dtos.Appointment.AppointmentRequest;
import com.piresvet.adapters.inbound.dtos.Appointment.AppointmentResponse;
import com.piresvet.core.domain.Appointments;
import com.piresvet.core.domain.Pet;
import com.piresvet.core.domain.Vet;
import com.piresvet.dataModel.AppointmentEntity;
import com.piresvet.dataModel.PetEntity;
import com.piresvet.dataModel.VetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentMapper {

    private final PetMapper petMapper;
    private final VetMapper vetMapper;

    public Appointments toDomain(AppointmentEntity entity, Pet pet, Vet vet) {
        return new Appointments(
                entity.getId(),
                entity.getExpected(),
                entity.getServices(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                pet,
                vet,
                entity.getIsFinished());
    }

    public AppointmentEntity toEntity(Appointments appointment, PetEntity pet, VetEntity vet) {
        return AppointmentEntity.builder()
                .expected(appointment.getExpected())
                .services(appointment.getServices())
                .updatedAt(null)
                .createdAt(null)
                .pet(pet)
                .vet(vet)
                .isFinished(appointment.getFinished())
                .build();
    }

    public Appointments toDomain(AppointmentRequest request, Pet pet, Vet vet) {
        return new Appointments(
               null,
                request.expected(),
                request.services(),
                null,
                null,
                pet,
                vet,
                false);
    }

    public AppointmentResponse toResponse(Appointments appointments) {
        var petResponse = petMapper.toResponse(appointments.getPet(), appointments.getPet().getPetOwner());
        var vetResponse = vetMapper.toResponse(appointments.getVet());

        return new AppointmentResponse(
                appointments.getId(),
                appointments.getExpected(),
                appointments.getServices(),
                appointments.getCreatedAt(),
                appointments.getUpdatedAt(),
                petResponse,
                vetResponse,
                appointments.getFinished()

        );
    }

}
