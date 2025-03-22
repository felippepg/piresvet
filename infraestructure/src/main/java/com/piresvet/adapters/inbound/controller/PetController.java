package com.piresvet.adapters.inbound.controller;

import com.piresvet.adapters.inbound.dtos.Pet.PetRequest;
import com.piresvet.adapters.inbound.dtos.Pet.PetResponse;
import com.piresvet.dataMapper.PetMapper;
import com.piresvet.useCaseContracts.Pet.CreatePetUseCase;
import com.piresvet.useCaseContracts.Pet.DeletePetUseCase;
import com.piresvet.useCaseContracts.Pet.FindPetsUseCase;
import com.piresvet.useCaseContracts.Pet.UpdatePetUseCase;
import com.piresvet.useCaseContracts.PetOwner.FindPetOwnerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
public class PetController {
    private final CreatePetUseCase createPetUseCase;
    private final FindPetOwnerUseCase findPetOwnerUseCase;
    private final FindPetsUseCase findPetsUseCase;
    private final UpdatePetUseCase updatePetUseCase;
    private final DeletePetUseCase deletePetUseCase;
    private final PetMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<PetResponse> create(@RequestBody PetRequest request, UriComponentsBuilder uriComponentsBuilder) {
        var owner = findPetOwnerUseCase.findById(request.owner());
        var pet = createPetUseCase.create(mapper.toDomain(request, owner));
        var uri = uriComponentsBuilder.path("/api/v1/pets/find{id}").buildAndExpand(pet.getId()).toUri();

        return ResponseEntity.created(uri).body(mapper.toResponse(pet, owner));
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") UUID id) {
        var pet = findPetsUseCase.findPetById(id);
        return ResponseEntity.ok(mapper.toResponse(pet, pet.getPetOwner()));
    }

    @GetMapping("/find-all")
    public ResponseEntity<?> findAll() {
        var pets = findPetsUseCase.findAllPets();
        return ResponseEntity.ok(pets.stream().map(pet -> mapper.toResponse(pet, pet.getPetOwner())));
    }

    @GetMapping("/find")
    public ResponseEntity<?> findByCpf(@RequestParam(name = "cpf", required = true) String cpf) {
        var pets = findPetsUseCase.findByPetOwnerCpf(cpf);
        return ResponseEntity.ok(pets.stream()
                .map(pet -> mapper.toResponse(pet, pet.getPetOwner()))
                .collect(Collectors.toList()));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id, @RequestBody PetRequest request) {
        var owner = findPetOwnerUseCase.findById(request.owner());
        var pet = mapper.toDomain(request, owner);
        var newPet = updatePetUseCase.update(id, pet);
        return ResponseEntity.ok(mapper.toResponse(newPet, newPet.getPetOwner()));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") UUID id){
        deletePetUseCase.delete(id);
    }

}
