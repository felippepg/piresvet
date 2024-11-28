package com.piresvet.gateway.Appointments;

import com.piresvet.core.domain.Vet;

public interface VerifyAvailableVetGateway {
    boolean verify(Vet vet);
}
