package com.piresvet.useCaseImplementation.Appointment;

import com.piresvet.core.domain.Appointments;
import com.piresvet.core.exception.AppointmentNotFoundException;
import com.piresvet.gatewayContracts.Appointments.FindAppointmentsGateway;
import com.piresvet.gatewayContracts.Appointments.FinishedAppointmentsGateway;
import com.piresvet.useCaseContracts.Appointment.FindAppointmentsUseCase;
import com.piresvet.useCaseContracts.Appointment.FinishedAppointmentsUseCase;

import java.util.NoSuchElementException;
import java.util.UUID;

public class FinishedAppointmentsUseCaseImpl implements FinishedAppointmentsUseCase {
    private FinishedAppointmentsGateway finishedAppointmentsGateway;
    private FindAppointmentsGateway findAppointmentsGateway;

    public FinishedAppointmentsUseCaseImpl(FinishedAppointmentsGateway finishedAppointmentsGateway, FindAppointmentsGateway findAppointmentsGateway) {
        this.finishedAppointmentsGateway = finishedAppointmentsGateway;
        this.findAppointmentsGateway = findAppointmentsGateway;
    }

    @Override
    public Appointments finished(UUID id) {
        findAppointmentsGateway.findById(id)
                        .orElseThrow(() -> new AppointmentNotFoundException("Não foi possível localizar consulta"));
        return finishedAppointmentsGateway.finished(id);
    }
}
