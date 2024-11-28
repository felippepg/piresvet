package com.piresvet.useCaseContracts.Appointment;

import com.piresvet.core.domain.Pet;

public interface VerifyAvailablePetUseCase {
    boolean verify(Pet pet);
}
