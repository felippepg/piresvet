package com.piresvet.useCaseImplementation.Appointment;

import com.piresvet.core.domain.Appointments;
import com.piresvet.core.exception.InvalidAppointmentsException;
import com.piresvet.gatewayContracts.Appointments.CreateAppointmentGateway;
import com.piresvet.gatewayContracts.Appointments.VerifyAvailablePetGateway;
import com.piresvet.gatewayContracts.Appointments.VerifyAvailableVetGateway;
import com.piresvet.useCaseContracts.Appointment.CreateAppointmentUseCase;

public class CreateAppointmentUseCaseImpl implements CreateAppointmentUseCase {
    private final CreateAppointmentGateway createAppointmentGateway;
    private final VerifyAvailablePetGateway verifyAvailablePetGateway;
    private final VerifyAvailableVetGateway verifyAvailableVetGateway;

    public CreateAppointmentUseCaseImpl(CreateAppointmentGateway createAppointmentGateway, VerifyAvailablePetGateway verifyAvailablePetGateway, VerifyAvailableVetGateway verifyAvailableVetGateway) {
        this.createAppointmentGateway = createAppointmentGateway;
        this.verifyAvailablePetGateway = verifyAvailablePetGateway;
        this.verifyAvailableVetGateway = verifyAvailableVetGateway;
    }


    @Override
    public Appointments create(Appointments appointment) {
        if(verifyAvailablePetGateway.verify(appointment.getPet()) && verifyAvailableVetGateway.verify(appointment.getVet())) {
            appointment.getVet().setAvailable(false);
            appointment.getPet().setAvailable(false);
            return createAppointmentGateway.create(appointment);
        }
        throw new InvalidAppointmentsException("Não foi possivel cadastrar consulta, verifique disponibilidade do veteriário e do pet");
    }
}
