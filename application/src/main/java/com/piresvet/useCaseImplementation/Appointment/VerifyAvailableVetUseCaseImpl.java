package com.piresvet.useCaseImplementation.Appointment;

import com.piresvet.core.domain.Vet;
import com.piresvet.gatewayContracts.Appointments.VerifyAvailableVetGateway;
import com.piresvet.useCaseContracts.Appointment.VerifyAvailableVetUseCase;

public class VerifyAvailableVetUseCaseImpl implements VerifyAvailableVetUseCase {
    private final VerifyAvailableVetGateway verifyAvailableVetGateway;

    public VerifyAvailableVetUseCaseImpl(VerifyAvailableVetGateway verifyAvailableVetGateway) {
        this.verifyAvailableVetGateway = verifyAvailableVetGateway;
    }

    @Override
    public boolean verify(Vet vet) {
        return verifyAvailableVetGateway.verify(vet);
    }
}
