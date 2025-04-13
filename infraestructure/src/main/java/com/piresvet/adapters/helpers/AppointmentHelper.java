package com.piresvet.adapters.helpers;

import com.piresvet.adapters.inbound.dtos.Appointment.AppointmentRequest;
import com.piresvet.core.domain.Appointments;
import com.piresvet.core.exception.InvalidAppointmentsException;
import com.piresvet.core.exception.InvalidAppointmentsStructureException;
import com.piresvet.dataMapper.AppointmentMapper;
import com.piresvet.useCaseContracts.Pet.FindPetsUseCase;
import com.piresvet.useCaseContracts.Vet.FindVetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentHelper {

    private final FindPetsUseCase findPetsUseCase;
    private final FindVetUseCase findVetUseCase;
    private final AppointmentMapper appointmentMapper;

    public static void validate(AppointmentRequest appointmentRequest) {
        if(appointmentRequest.pet() == null) {
            throw new InvalidAppointmentsStructureException("Não é possivel criar uma consulta sem Pet!");
        }
        if(appointmentRequest.vet() == null) {
            throw new InvalidAppointmentsStructureException("Não é possivel criar uma consulta sem um veterinário!");
        }
        if(appointmentRequest.services() == null) {
            throw new InvalidAppointmentsStructureException("Não é possivel criar uma consulta sem um serviço!");
        }


    }

    public Appointments generate(AppointmentRequest request) {
        var pet = findPetsUseCase.findPetById(request.pet());
        var vet = findVetUseCase.findById(request.vet());

        return  appointmentMapper.toDomain(request, pet, vet);
    }
}
