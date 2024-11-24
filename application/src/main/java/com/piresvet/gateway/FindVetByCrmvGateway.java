package com.piresvet.gateway;

import com.piresvet.core.domain.Vet;

public interface FindVetByCrmvGateway {
    Vet find(String crmv);
}
