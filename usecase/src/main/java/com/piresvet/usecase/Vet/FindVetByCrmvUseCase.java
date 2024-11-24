package com.piresvet.usecase.Vet;

import com.piresvet.core.domain.Vet;

public interface FindVetByCrmvUseCase {
    Vet find(String Crmv);
}
