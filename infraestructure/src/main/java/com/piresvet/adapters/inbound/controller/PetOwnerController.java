package com.piresvet.adapters.inbound.controller;

import com.piresvet.adapters.helpers.PetOwnerHelper;
import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerPatchRequest;
import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerRequest;
import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerResponse;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.useCaseContracts.PetOwner.CreatePetOwnerUseCase;
import com.piresvet.useCaseContracts.PetOwner.DeletePetOwnerUseCase;
import com.piresvet.useCaseContracts.PetOwner.FindPetOwnerUseCase;
import com.piresvet.useCaseContracts.PetOwner.UpdatePetOwnerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/pet-owner")
@RequiredArgsConstructor
public class PetOwnerController {
    private final CreatePetOwnerUseCase createPetOwnerUseCase;
    private final FindPetOwnerUseCase findPetOwnerUseCase;
    private final DeletePetOwnerUseCase deletePetOwnerUseCase;
    private final UpdatePetOwnerUseCase updatePetOwnerUseCase;
    private final PetOwnerMapper mapper;
    private final PetOwnerHelper petOwnerHelper;


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

    @GetMapping("/find-all")
    public ResponseEntity<List<PetOwnerResponse>> getAllPetOwners() {
        var petOwners = findPetOwnerUseCase.findAll();
        return ResponseEntity.ok(petOwners.stream().map(mapper::toResponse).collect(Collectors.toList()));
    }

    @GetMapping("/find")
    public ResponseEntity<?> findPetOwners(
            @RequestParam(name = "cpf", required = false) String cpf,
            @RequestParam(name = "firstname", required = false) String firstname,
            @RequestParam(name = "lastname", required = false) String lastname) {

        if(cpf != null) {
            var petOwner = findPetOwnerUseCase.findByCpf(cpf);
            return ResponseEntity.ok(mapper.toResponse(petOwner));
        }

        if(firstname != null && lastname == null) {
            var petOwners = findPetOwnerUseCase.findByName(firstname);
            return ResponseEntity.ok(petOwners.stream().map(mapper::toResponse).collect(Collectors.toList()));
        }

        if (firstname != null) {
            var petOwners = findPetOwnerUseCase.findByFullname(firstname, lastname);
            return ResponseEntity.ok(petOwners.stream().map(mapper::toResponse).collect(Collectors.toList()));
        }

        return ResponseEntity.badRequest().body("Informe pelo menos um parâmetro para a busca.");
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<PetOwnerResponse> updatePetOwner(@PathVariable("id") UUID id, @RequestBody PetOwnerPatchRequest request) {
        var petOwnerDomain = petOwnerHelper.generate(request, id);
        var newPetOwner = updatePetOwnerUseCase.update(id, petOwnerDomain);
        return ResponseEntity.ok().body(mapper.toResponse(newPetOwner));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePetOwner(@PathVariable("id") UUID id) {
        deletePetOwnerUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }


}
