package com.piresvet.usecase.Vet;

import com.piresvet.core.domain.Vet;

import java.util.List;

public interface FindVetByFullNameUseCase {
    List<Vet> find(String firstname, String lastname);
}
