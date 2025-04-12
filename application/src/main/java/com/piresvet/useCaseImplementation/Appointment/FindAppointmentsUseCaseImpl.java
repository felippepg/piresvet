package com.piresvet.useCaseImplementation.Appointment;

import com.piresvet.core.domain.Appointments;
import com.piresvet.core.exception.AppointmentNotFoundException;
import com.piresvet.gatewayContracts.Appointments.FindAppointmentsGateway;
import com.piresvet.useCaseContracts.Appointment.FindAppointmentsUseCase;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public class FindAppointmentsUseCaseImpl implements FindAppointmentsUseCase {
    private final FindAppointmentsGateway findAppointmentsGateway;

    public FindAppointmentsUseCaseImpl(FindAppointmentsGateway findAppointmentsGateway) {
        this.findAppointmentsGateway = findAppointmentsGateway;
    }

    @Override
    public List<Appointments> findAll() {
        return findAppointmentsGateway.findAll();
    }

    @Override
    public Appointments findById(UUID id) {
        var optional = findAppointmentsGateway.findById(id);
        return optional.orElseThrow(() -> new AppointmentNotFoundException("Não foi possivel localizar consulta"));
    }

    @Override
    public List<Appointments> findByCpfOwner(String cpf) {
        var appointments = findAppointmentsGateway.findByCpfOwner(cpf);

        if (appointments == null) {
            throw new AppointmentNotFoundException("Não foi possível localizar consulta com esse CPF do tutor do Pet!");
        }

        return appointments;
    }

}
