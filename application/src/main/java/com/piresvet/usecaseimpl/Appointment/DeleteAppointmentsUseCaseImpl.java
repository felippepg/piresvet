package com.piresvet.usecaseimpl.Appointment;

import com.piresvet.gateway.Appointments.DeleteAppointmentsGateway;
import com.piresvet.gateway.Appointments.FindAppointmentsGateway;
import com.piresvet.usecase.Appointment.DeleteAppointmentsUseCase;

import java.util.UUID;

public class DeleteAppointmentsUseCaseImpl implements DeleteAppointmentsUseCase {
    private final DeleteAppointmentsGateway deleteAppointmentsGateway;
    private final FindAppointmentsGateway findAppointmentsGateway;

    public DeleteAppointmentsUseCaseImpl(DeleteAppointmentsGateway deleteAppointmentsGateway, FindAppointmentsGateway findAppointmentsGateway) {
        this.deleteAppointmentsGateway = deleteAppointmentsGateway;
        this.findAppointmentsGateway = findAppointmentsGateway;
    }

    @Override
    public void delete(UUID id) {
        findAppointmentsGateway.findById(id);
        deleteAppointmentsGateway.delete(id);
    }
}
