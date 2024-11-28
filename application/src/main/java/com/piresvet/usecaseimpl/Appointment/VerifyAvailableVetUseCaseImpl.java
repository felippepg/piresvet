package com.piresvet.usecaseimpl.Appointment;

import com.piresvet.core.domain.Pet;
import com.piresvet.core.domain.Vet;
import com.piresvet.gateway.Appointments.VerifyAvailablePetGateway;
import com.piresvet.gateway.Appointments.VerifyAvailableVetGateway;
import com.piresvet.usecase.Appointment.VerifyAvailablePetUseCase;
import com.piresvet.usecase.Appointment.VerifyAvailableVetUseCase;

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
