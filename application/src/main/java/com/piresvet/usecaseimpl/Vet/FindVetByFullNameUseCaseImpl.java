package com.piresvet.usecaseimpl.Vet;

import com.piresvet.core.domain.Vet;
import com.piresvet.gateway.Vet.FindVetByFullNameGateway;
import com.piresvet.usecase.Vet.FindVetByFullNameUseCase;

import java.util.List;

public class FindVetByFullNameUseCaseImpl implements FindVetByFullNameUseCase {
    private final FindVetByFullNameGateway findVetByFullNameGateway;

    public FindVetByFullNameUseCaseImpl(FindVetByFullNameGateway findVetByFullNameGateway) {
        this.findVetByFullNameGateway = findVetByFullNameGateway;
    }

    @Override
    public List<Vet> find(String firstname, String lastname) {
        return findVetByFullNameGateway.find(firstname, lastname);
    }
}
