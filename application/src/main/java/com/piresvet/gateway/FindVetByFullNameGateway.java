package com.piresvet.gateway;

import com.piresvet.core.domain.Vet;

import java.util.List;

public interface FindVetByFullNameGateway {
    List<Vet> find(String firstname, String lastname);
}
