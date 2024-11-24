package com.piresvet.gateway;

import com.piresvet.core.domain.Vet;

import java.util.List;

public interface FindAvailableVetsGateway {
    List<Vet> getVets();
}
