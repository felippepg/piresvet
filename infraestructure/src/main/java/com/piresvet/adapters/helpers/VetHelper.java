package com.piresvet.adapters.helpers;

import com.piresvet.adapters.inbound.dtos.Vet.VetPatchRequest;
import com.piresvet.adapters.inbound.dtos.Vet.VetRequest;
import com.piresvet.core.domain.Vet;
import com.piresvet.dataMapper.VetMapper;
import com.piresvet.useCaseContracts.Vet.FindVetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VetHelper {

    private final FindVetUseCase findVetUseCase;
    private final VetMapper mapper;

    public Vet generate(VetPatchRequest patch, UUID id) {
        var vet = findVetUseCase.findById(id);
        var request = new VetRequest(patch.firstname(), patch.lastname(), vet.getCrmv());
        return mapper.toDomain(request);
    }
}
