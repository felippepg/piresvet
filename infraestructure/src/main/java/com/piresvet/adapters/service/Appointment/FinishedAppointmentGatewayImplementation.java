package com.piresvet.adapters.service.Appointment;

import com.piresvet.core.domain.Appointments;
import com.piresvet.dataMapper.AppointmentMapper;
import com.piresvet.dataMapper.PetMapper;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.dataMapper.VetMapper;
import com.piresvet.gatewayContracts.Appointments.FinishedAppointmentsGateway;
import com.piresvet.persistence.AppointmentRepository;
import com.piresvet.persistence.PetRepository;
import com.piresvet.persistence.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor

public class FinishedAppointmentGatewayImplementation implements FinishedAppointmentsGateway {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    private final VetRepository vetRepository;
    private final VetMapper vetMapper;

    private final PetOwnerMapper petOwnerMapper;
    private final PetRepository petRepository;
    private final PetMapper petMapper;
    @Override
    public Appointments finished(UUID id) {
        var appointment = appointmentRepository.findById(id).get();

        var vet = vetRepository.findById(appointment.getVet().getId()).get();
        vet.setAvailable(true);
        appointment.setVet(vetRepository.save(vet));

        var pet = petRepository.findById(appointment.getPet().getId()).get();
        pet.setAvailable(true);
        appointment.setPet(petRepository.save(pet));

        appointment.setIsFinished(true);
        var finished = appointmentRepository.save(appointment);

        return appointmentMapper.toDomain(
                finished,
                petMapper.toDomain(finished.getPet(),
                        petOwnerMapper.toDomain(finished.getPet().getPetOwner())),
                vetMapper.toDomain(finished.getVet()));

    }
}
