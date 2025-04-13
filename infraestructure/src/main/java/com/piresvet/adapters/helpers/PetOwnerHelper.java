package com.piresvet.adapters.helpers;

import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerPatchRequest;
import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerRequest;
import com.piresvet.adapters.inbound.dtos.Vet.VetPatchRequest;
import com.piresvet.adapters.inbound.dtos.Vet.VetRequest;
import com.piresvet.core.domain.PetOwner;
import com.piresvet.core.domain.Vet;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.dataMapper.VetMapper;
import com.piresvet.useCaseContracts.PetOwner.FindPetOwnerUseCase;
import com.piresvet.useCaseContracts.Vet.FindVetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PetOwnerHelper {

    private final FindPetOwnerUseCase findPetOwnerUseCase;
    private final PetOwnerMapper mapper;

    public PetOwner generate(PetOwnerPatchRequest patch, UUID id) {
        var owner = findPetOwnerUseCase.findById(id);
        var request = new PetOwnerRequest(patch.firstname(), patch.lastname(), owner.getCpf().getCpf());
        return mapper.toDomain(request);
    }
}
