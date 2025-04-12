package com.piresvet.useCaseImplementation.Appointment;

import com.piresvet.core.domain.Appointments;
import com.piresvet.core.exception.AppointmentNotFoundException;
import com.piresvet.gatewayContracts.Appointments.FindAppointmentsGateway;
import com.piresvet.gatewayContracts.Appointments.UpdateAppointmentsGateway;
import com.piresvet.useCaseContracts.Appointment.UpdateAppointmentsUseCase;

import java.util.UUID;

public class UpdateAppointmentsUseCaseImpl implements UpdateAppointmentsUseCase {
    private final UpdateAppointmentsGateway updateAppointmentsGateway;
    private final FindAppointmentsGateway findAppointmentsGateway;

    public UpdateAppointmentsUseCaseImpl(UpdateAppointmentsGateway updateAppointmentsGateway, FindAppointmentsGateway findAppointmentsGateway) {
        this.updateAppointmentsGateway = updateAppointmentsGateway;
        this.findAppointmentsGateway = findAppointmentsGateway;
    }

    @Override
    public Appointments update(UUID id, Appointments appointments) {
        findAppointmentsGateway.findById(id).orElseThrow(
                () -> new AppointmentNotFoundException("Não foi possivel localizar consulta!"));
        return updateAppointmentsGateway.update(id, appointments);
    }
}
