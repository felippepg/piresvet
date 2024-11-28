package com.piresvet.useCaseContracts.Appointment;

import com.piresvet.core.domain.Vet;

public interface VerifyAvailableVetUseCase {
    boolean verify(Vet vet);
}
