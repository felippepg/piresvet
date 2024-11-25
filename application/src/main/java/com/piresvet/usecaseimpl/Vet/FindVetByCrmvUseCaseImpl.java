package com.piresvet.usecaseimpl.Vet;

import com.piresvet.core.domain.Vet;
import com.piresvet.core.exception.InvalidCrmvException;
import com.piresvet.gateway.Vet.FindVetByCrmvGateway;
import com.piresvet.usecase.Vet.FindVetByCrmvUseCase;

public class FindVetByCrmvUseCaseImpl implements FindVetByCrmvUseCase {
    private final FindVetByCrmvGateway findVetByCrmvGateway;

    public FindVetByCrmvUseCaseImpl(FindVetByCrmvGateway findVetByCrmvGateway) {
        this.findVetByCrmvGateway = findVetByCrmvGateway;
    }

    @Override
    public Vet find(String crmv) {
        var optional = findVetByCrmvGateway.find(crmv);
        return optional.orElseThrow(() -> new InvalidCrmvException("CRMV não encontrado"));
    }
}
