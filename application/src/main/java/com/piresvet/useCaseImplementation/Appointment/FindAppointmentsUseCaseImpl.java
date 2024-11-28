package com.piresvet.useCaseImplementation.Appointment;

import com.piresvet.core.domain.Appointments;
import com.piresvet.gatewayContracts.Appointments.FindAppointmentsGateway;
import com.piresvet.useCaseContracts.Appointment.FindAppointmentsUseCase;

import java.util.List;
import java.util.NoSuchElementException;
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
        return optional.orElseThrow(() -> new NoSuchElementException("Não foi possivel localizar consulta"));
    }
}
