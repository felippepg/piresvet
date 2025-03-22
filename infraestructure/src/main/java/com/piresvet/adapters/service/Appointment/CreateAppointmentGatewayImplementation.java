package com.piresvet.adapters.service.Appointment;

import com.piresvet.core.domain.Appointments;
import com.piresvet.dataMapper.AppointmentMapper;
import com.piresvet.gatewayContracts.Appointments.CreateAppointmentGateway;
import com.piresvet.persistence.AppointmentRepository;
import com.piresvet.persistence.PetRepository;
import com.piresvet.persistence.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAppointmentGatewayImplementation implements CreateAppointmentGateway {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final PetRepository petRepository;
    private final VetRepository vetRepository;

    @Override
    public Appointments create(Appointments appointment) {
        var petDatabase = petRepository.findById(appointment.getPet().getId()).get();
        var vetDatabase = vetRepository.findById(appointment.getVet().getId()).get();


        petDatabase.setAvailable(appointment.getPet().isAvailable());
        vetDatabase.setAvailable(appointment.getVet().getAvailable());

        var petEntity = petRepository.save(petDatabase);
        var vetEntity = vetRepository.save(vetDatabase);

        var entity = appointmentMapper.toEntity(appointment, petEntity, vetEntity);
        var response = appointmentRepository.save(entity);

        return appointmentMapper.toDomain(response, appointment.getPet(), appointment.getVet());
    }
}
