package com.piresvet.adapters.inbound.controller;

import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerRequest;
import com.piresvet.adapters.inbound.dtos.PetOwner.PetOwnerResponse;
import com.piresvet.adapters.inbound.dtos.Vet.VetRequest;
import com.piresvet.adapters.inbound.dtos.Vet.VetResponse;
import com.piresvet.core.domain.Vet;
import com.piresvet.dataMapper.VetMapper;
import com.piresvet.useCaseContracts.Vet.CreateVetUseCase;
import com.piresvet.useCaseContracts.Vet.DeleteVetUseCase;
import com.piresvet.useCaseContracts.Vet.FindVetUseCase;
import com.piresvet.useCaseContracts.Vet.UpdateVetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vet")
@RequiredArgsConstructor
public class VetController {

    private final CreateVetUseCase createVetUseCase;
    private final DeleteVetUseCase deleteVetUseCase;
    private final UpdateVetUseCase updateVetUseCase;
    private final FindVetUseCase findVetUseCase;
    private final VetMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<VetResponse> createVet(@RequestBody VetRequest request) {
        var vet = createVetUseCase.create(mapper.toDomain(request));
        return ResponseEntity.ok(mapper.toResponse(vet));
    }

    @GetMapping("/find-all")
    public List<VetResponse> getVets() {
        var vets = findVetUseCase.findAll();
        return vets.stream()
                .map(vet -> new VetResponse(vet.getId(), vet.getFirstname(), vet.getLastname(), vet.getCrmv()))
                .collect(Collectors.toList());
    }

    @GetMapping("/find-available")
    public ResponseEntity<List<VetResponse>> getAvailableVets() {
        var vets = findVetUseCase.findAvailable();
        var response = vets.stream().map(vet -> new VetResponse(vet.getId(), vet.getFirstname(), vet.getLastname(), vet.getCrmv())).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<VetResponse> getVetById(@PathVariable("id")UUID id) {
        var vet = findVetUseCase.findById(id);
        var response = new VetResponse(vet.getId(), vet.getFirstname(), vet.getLastname(), vet.getCrmv());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/find")
    public ResponseEntity<?> findVet(
            @RequestParam(name = "crmv", required = false) String crmv,
            @RequestParam(name = "firstname", required = false) String firstname,
            @RequestParam(name = "lastname", required = false) String lastname) {

        if(crmv != null) {
            var vet = findVetUseCase.findByCrm(crmv);
            return ResponseEntity.ok(mapper.toResponse(vet));
        }

        if(firstname != null && lastname == null) {
            var vet = findVetUseCase.findByName(firstname);
            return ResponseEntity.ok(vet.stream().map(mapper::toResponse).collect(Collectors.toList()));
        }

        if (firstname != null) {
            var vet = findVetUseCase.findByFullname(firstname, lastname);
            return ResponseEntity.ok(vet.stream().map(mapper::toResponse).collect(Collectors.toList()));
        }

        return ResponseEntity.badRequest().body("Informe pelo menos um parâmetro para a busca.");
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<VetResponse> updateVet(@PathVariable("id") UUID id, @RequestBody VetRequest request) {
        var newVet = updateVetUseCase.update(id, mapper.toDomain(request));
        return ResponseEntity.ok().body(mapper.toResponse(newVet));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVet(@PathVariable("id") UUID id) {
        deleteVetUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }


}
