package com.piresvet.adapters.inbound.controller;

import com.piresvet.adapters.inbound.dtos.Pet.PetRequest;
import com.piresvet.adapters.inbound.dtos.Pet.PetResponse;
import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerRequest;
import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerResponse;
import com.piresvet.dataMapper.PetMapper;
import com.piresvet.useCaseContracts.Pet.CreatePetUseCase;
import com.piresvet.useCaseContracts.PetOwner.FindPetOwnerUseCase;
import com.piresvet.useCaseImplementation.Pet.CreatePetUseCaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
public class PetController {
    private final CreatePetUseCase createPetUseCase;
    private final FindPetOwnerUseCase findPetOwnerUseCase;
    private final PetMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<PetResponse> create(@RequestBody PetRequest request, UriComponentsBuilder uriComponentsBuilder) {
        var owner = findPetOwnerUseCase.findById(request.owner());
        var pet = createPetUseCase.create(mapper.toDomain(request, owner));
        var uri = uriComponentsBuilder.path("/api/v1/pets/find{id}").buildAndExpand(pet.getId()).toUri();

        return ResponseEntity.created(uri).body(mapper.toResponse(pet, owner));
    }


    public ResponseEntity<?> findById() {
        return null;
    }

    public ResponseEntity<?> findAll() {
        return null;
    }

    public ResponseEntity<?> update() {
        return null;
    }

    public void delete(){
        //
    }

}
