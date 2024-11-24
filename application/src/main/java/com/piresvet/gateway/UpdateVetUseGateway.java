package com.piresvet.gateway;

import com.piresvet.core.domain.Vet;

import java.util.UUID;

public interface UpdateVetUseGateway {
    Vet update(UUID id);
}
