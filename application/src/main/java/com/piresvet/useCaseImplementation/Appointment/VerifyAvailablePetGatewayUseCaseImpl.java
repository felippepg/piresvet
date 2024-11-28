package com.piresvet.useCaseImplementation.Appointment;

import com.piresvet.core.domain.Pet;
import com.piresvet.gatewayContracts.Appointments.VerifyAvailablePetGateway;
import com.piresvet.useCaseContracts.Appointment.VerifyAvailablePetUseCase;

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
