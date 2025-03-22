package com.piresvet.adapters.inbound.controller;

import com.piresvet.adapters.inbound.dtos.Vet.VetRequest;
import com.piresvet.adapters.inbound.dtos.Vet.VetResponse;
import com.piresvet.core.domain.Vet;
import com.piresvet.dataMapper.VetMapper;
import com.piresvet.useCaseContracts.Vet.CreateVetUseCase;
import com.piresvet.useCaseContracts.Vet.FindVetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vet")
@RequiredArgsConstructor
public class VetController {

    private final CreateVetUseCase createVetUseCase;
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
                .map(vet -> new VetResponse(vet.getId(), vet.getFirstname(), vet.getLastname(), vet.getCrmv(), vet.getAvailable()))
                .collect(Collectors.toList());
    }


}
