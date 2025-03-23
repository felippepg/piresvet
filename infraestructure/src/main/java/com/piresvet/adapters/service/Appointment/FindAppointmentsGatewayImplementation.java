package com.piresvet.adapters.service.Appointment;

import com.piresvet.core.domain.Appointments;
import com.piresvet.dataMapper.AppointmentMapper;
import com.piresvet.dataMapper.PetMapper;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.dataMapper.VetMapper;
import com.piresvet.dataModel.AppointmentEntity;
import com.piresvet.gatewayContracts.Appointments.FindAppointmentsGateway;
import com.piresvet.persistence.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAppointmentsGatewayImplementation implements FindAppointmentsGateway {
    public final AppointmentRepository appointmentRepository;
    public final AppointmentMapper appointmentMapper;
    public final PetMapper petMapper;
    public final VetMapper vetMapper;
    public final PetOwnerMapper petOwnerMapper;


    @Override
    public List<Appointments> findAll() {
        var entityAppointments = appointmentRepository.findAll();
        return entityAppointments
                .stream()
                .map(entity -> appointmentMapper.toDomain(
                        entity,
                        petMapper.toDomain(entity.getPet(), petOwnerMapper.toDomain(entity.getPet().getPetOwner())),
                        vetMapper.toDomain(entity.getVet())))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Appointments> findById(UUID id) {
        return appointmentRepository.findById(id)
                .map(entity -> appointmentMapper.toDomain(
                        entity,
                        petMapper.toDomain(entity.getPet(), petOwnerMapper.toDomain(entity.getPet().getPetOwner())),
                        vetMapper.toDomain((entity.getVet()))
                ));
    }

    @Override
    public List<Appointments> findByCpfOwner(String cpf) {
        List<AppointmentEntity> entityAppointments = appointmentRepository.findByPet_PetOwner_Cpf(cpf);
        return entityAppointments.stream()
                .map(entity -> appointmentMapper.toDomain(
                        entity,
                        petMapper.toDomain(entity.getPet(), petOwnerMapper.toDomain(entity.getPet().getPetOwner())),
                        vetMapper.toDomain((entity.getVet()))
                )).collect(Collectors.toList());
    }
}
