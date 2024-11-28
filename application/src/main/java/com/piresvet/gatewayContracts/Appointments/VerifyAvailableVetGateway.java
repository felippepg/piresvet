package com.piresvet.gatewayContracts.Appointments;

import com.piresvet.core.domain.Vet;

public interface VerifyAvailableVetGateway {
    boolean verify(Vet vet);
}
