package com.piresvet.usecaseimpl.Appointment;

import com.piresvet.core.domain.Appointments;
import com.piresvet.gateway.Appointments.FindAppointmentsGateway;
import com.piresvet.gateway.Appointments.UpdateAppointmentsGateway;
import com.piresvet.usecase.Appointment.UpdateAppointmentsUseCase;

import java.util.UUID;

public class UpdateAppointmentsUseCaseImpl implements UpdateAppointmentsUseCase {
    private final UpdateAppointmentsGateway updateAppointmentsGateway;
    private final FindAppointmentsGateway findAppointmentsGateway;

    public UpdateAppointmentsUseCaseImpl(UpdateAppointmentsGateway updateAppointmentsGateway, FindAppointmentsGateway findAppointmentsGateway) {
        this.updateAppointmentsGateway = updateAppointmentsGateway;
        this.findAppointmentsGateway = findAppointmentsGateway;
    }

    @Override
    public Appointments update(UUID id) {
        findAppointmentsGateway.findById(id);
        return updateAppointmentsGateway.update(id);
    }
}
