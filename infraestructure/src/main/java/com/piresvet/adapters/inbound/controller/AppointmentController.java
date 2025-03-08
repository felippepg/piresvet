package com.piresvet.adapters.inbound.controller;

import com.piresvet.adapters.inbound.dtos.Appointment.AppointmentRequest;
import com.piresvet.adapters.inbound.dtos.Appointment.AppointmentResponse;
import com.piresvet.dataMapper.AppointmentMapper;
import com.piresvet.useCaseContracts.Appointment.CreateAppointmentUseCase;
import com.piresvet.useCaseContracts.Pet.FindPetsUseCase;
import com.piresvet.useCaseContracts.Vet.FindVetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final CreateAppointmentUseCase createAppointmentUseCase;

    private final FindPetsUseCase findPetsUseCase;
    private final FindVetUseCase findVetUseCase;
    private final AppointmentMapper appointmentMapper;

    @PostMapping("/create")
    public ResponseEntity<AppointmentResponse> createVet(@RequestBody AppointmentRequest request) {
        var pet = findPetsUseCase.findPetById(request.pet());
        var vet = findVetUseCase.findById(request.vet());
        var appointment = appointmentMapper.toDomain(request, pet, vet);
        var response = createAppointmentUseCase.create(appointment);
        return ResponseEntity.ok(appointmentMapper.toResponse(response));
    }

//    @GetMapping("/find-all")
//    public List<VetResponse> getVets() {
//        var vets = findVetUseCase.findAll();
//        return vets.stream()
//                .map(vet -> new VetResponse(vet.getFirstname(), vet.getLastname(), vet.getCrmv()))
//                .collect(Collectors.toList());
//    }


}
