package com.piresvet.adapters.inbound.controller;

import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerRequest;
import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerResponse;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.useCaseContracts.PetOwner.CreatePetOwnerUseCase;
import com.piresvet.useCaseContracts.PetOwner.FindPetOwnerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pet-owner")
@RequiredArgsConstructor
public class PetOwnerController {
    private final CreatePetOwnerUseCase createPetOwnerUseCase;
    private final FindPetOwnerUseCase findPetOwnerUseCase;
    private final PetOwnerMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<PetOwnerResponse> createPetOwner(@RequestBody PetOwnerRequest request, UriComponentsBuilder uriComponentsBuilder) {
        var petOwner = createPetOwnerUseCase.create(mapper.toDomain(request));
        var uri = uriComponentsBuilder.path("/api/v1/pet-owner/find/{id}").buildAndExpand(petOwner.getId()).toUri();
        return ResponseEntity.created(uri).body(mapper.toResponse(petOwner));
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<PetOwnerResponse> findPetOwnerById(@PathVariable("id") UUID id) {
        var petOwner = findPetOwnerUseCase.findById(id);
        return ResponseEntity.ok(mapper.toResponse(petOwner));
    }


}
