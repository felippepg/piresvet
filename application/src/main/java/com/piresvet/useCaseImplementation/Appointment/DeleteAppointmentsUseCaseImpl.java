package com.piresvet.useCaseImplementation.Appointment;

import com.piresvet.gatewayContracts.Appointments.DeleteAppointmentsGateway;
import com.piresvet.gatewayContracts.Appointments.FindAppointmentsGateway;
import com.piresvet.useCaseContracts.Appointment.DeleteAppointmentsUseCase;

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
