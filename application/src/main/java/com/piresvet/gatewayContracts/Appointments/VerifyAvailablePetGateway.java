package com.piresvet.gatewayContracts.Appointments;

import com.piresvet.core.domain.Pet;

public interface VerifyAvailablePetGateway {
    boolean verify(Pet pet);
}
