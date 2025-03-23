package com.piresvet.adapters.service.Appointment;

import com.piresvet.core.domain.Appointments;
import com.piresvet.dataMapper.AppointmentMapper;
import com.piresvet.dataMapper.PetMapper;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.dataMapper.VetMapper;
import com.piresvet.gatewayContracts.Appointments.UpdateAppointmentsGateway;
import com.piresvet.persistence.AppointmentRepository;
import com.piresvet.persistence.PetRepository;
import com.piresvet.persistence.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class UpdateAppointmentGatewayImplementation implements UpdateAppointmentsGateway {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    private final VetRepository vetRepository;
    private final VetMapper vetMapper;

    private final PetOwnerMapper petOwnerMapper;
    private final PetRepository petRepository;
    private final PetMapper petMapper;

    @Override
    public Appointments update(UUID id, Appointments newAppointment) {
        var appointment = appointmentRepository.findById(id).get();

        if(newAppointment.getVet() != null) {
            //Atualizando status do antigo veterinario no sistema
            var oldVetEntity = vetRepository.findById(appointment.getVet().getId()).get();
            oldVetEntity.setAvailable(true);
            vetRepository.save(oldVetEntity);

            var newVetEntity = vetRepository.findById(newAppointment.getVet().getId()).get();
            newVetEntity.setAvailable(false);

            appointment.setVet(vetRepository.save(newVetEntity));
        }
        if(newAppointment.getPet() != null) {
            //Atualizando status do antigo pet no sistema
            var oldPetEntity = petRepository.findById(appointment.getPet().getId()).get();
            oldPetEntity.setAvailable(true);
            petRepository.save(oldPetEntity);

            var newPetEntity = petRepository.findById(newAppointment.getPet().getId()).get();
            newPetEntity.setAvailable(false);

            appointment.setPet(petRepository.save(newPetEntity));
        }
        if(newAppointment.getExpected() != null) {
            appointment.setExpected(newAppointment.getExpected());
        }
        if(newAppointment.getServices() != null) {
            appointment.setServices(newAppointment.getServices());
        }

        var newAppointmentEntity =  appointmentRepository.save(appointment);
        return appointmentMapper.toDomain(
                newAppointmentEntity,
                petMapper.toDomain(
                        newAppointmentEntity.getPet(),
                        petOwnerMapper.toDomain(newAppointmentEntity.getPet().getPetOwner())
                ),
                vetMapper.toDomain(newAppointmentEntity.getVet())
        );
    }
}
