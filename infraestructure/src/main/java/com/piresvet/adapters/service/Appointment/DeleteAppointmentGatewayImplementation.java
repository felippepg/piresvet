package com.piresvet.adapters.service.Appointment;

import com.piresvet.gatewayContracts.Appointments.DeleteAppointmentsGateway;
import com.piresvet.persistence.AppointmentRepository;
import com.piresvet.persistence.PetRepository;
import com.piresvet.persistence.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class DeleteAppointmentGatewayImplementation implements DeleteAppointmentsGateway {
    private final AppointmentRepository appointmentRepository;
    private final VetRepository vetRepository;
    private final PetRepository petRepository;

    @Override
    public void delete(UUID id) {
        var appointment = appointmentRepository.findById(id).get();
        var vetEntity = vetRepository.findById(appointment.getVet().getId()).get();
        var petEntity = petRepository.findById(appointment.getPet().getId()).get();

        vetEntity.setAvailable(true);
        vetRepository.save(vetEntity);

        petEntity.setAvailable(true);
        petRepository.save(petEntity);

        appointmentRepository.delete(appointment);
    }
}
