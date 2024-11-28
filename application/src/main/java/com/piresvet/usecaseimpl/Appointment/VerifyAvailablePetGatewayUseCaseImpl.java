package com.piresvet.usecaseimpl.Appointment;

import com.piresvet.core.domain.Pet;
import com.piresvet.gateway.Appointments.VerifyAvailablePetGateway;
import com.piresvet.usecase.Appointment.VerifyAvailablePetUseCase;

public class VerifyAvailablePetGatewayUseCaseImpl implements VerifyAvailablePetUseCase {
    private final VerifyAvailablePetGateway verifyAvailablePetGateway;

    public VerifyAvailablePetGatewayUseCaseImpl(VerifyAvailablePetGateway verifyAvailablePetGateway) {
        this.verifyAvailablePetGateway = verifyAvailablePetGateway;
    }

    @Override
    public boolean verify(Pet pet) {
        return verifyAvailablePetGateway.verify(pet);
    }
}
