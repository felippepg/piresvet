package com.piresvet.adapters.inbound.controller;

import com.piresvet.adapters.inbound.dtos.Appointment.AppointmentRequest;
import com.piresvet.adapters.inbound.dtos.Appointment.AppointmentResponse;
import com.piresvet.dataMapper.AppointmentMapper;
import com.piresvet.useCaseContracts.Appointment.CreateAppointmentUseCase;
import com.piresvet.useCaseContracts.Appointment.DeleteAppointmentsUseCase;
import com.piresvet.useCaseContracts.Appointment.FindAppointmentsUseCase;
import com.piresvet.useCaseContracts.Appointment.UpdateAppointmentsUseCase;
import com.piresvet.useCaseContracts.Pet.FindPetsUseCase;
import com.piresvet.useCaseContracts.Vet.FindVetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final CreateAppointmentUseCase createAppointmentUseCase;

    private final FindPetsUseCase findPetsUseCase;
    private final FindVetUseCase findVetUseCase;
    private final AppointmentMapper appointmentMapper;
    private final FindAppointmentsUseCase findAppointmentsUseCase;
    private final UpdateAppointmentsUseCase updateAppointmentsUseCase;
    private final DeleteAppointmentsUseCase deleteAppointmentsUseCase;

    @PostMapping("/create")
    public ResponseEntity<AppointmentResponse> createVet(@RequestBody AppointmentRequest request) {
        var pet = findPetsUseCase.findPetById(request.pet());
        var vet = findVetUseCase.findById(request.vet());
        var appointment = appointmentMapper.toDomain(request, pet, vet);
        var response = createAppointmentUseCase.create(appointment);
        return ResponseEntity.ok(appointmentMapper.toResponse(response));
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<AppointmentResponse>> findAllAppointments() {
        var appointments = findAppointmentsUseCase.findAll();
        return ResponseEntity.ok(appointments.stream().map(appointmentMapper::toResponse).collect(Collectors.toList()));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AppointmentResponse> findAppointmentById(@PathVariable("id") UUID id) {
        var appointment = findAppointmentsUseCase.findById(id);
        return ResponseEntity.ok(appointmentMapper.toResponse(appointment));
    }

    @GetMapping("/find")
    public ResponseEntity<?> findByCpf(@RequestParam(name = "cpf", required = true) String cpf) {
        var appointments = findAppointmentsUseCase.findByCpfOwner(cpf);
        return ResponseEntity.ok(appointments.stream().map(appointmentMapper::toResponse));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<AppointmentResponse> updateAppointment(
            @PathVariable("id") UUID id, @RequestBody AppointmentRequest request) {
        var pet = findPetsUseCase.findPetById(request.pet());
        var vet = findVetUseCase.findById(request.vet());
        var appointment = appointmentMapper.toDomain(request, pet, vet);
        var response = updateAppointmentsUseCase.update(id, appointment);

        return ResponseEntity.ok(appointmentMapper.toResponse(response));

    }

    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<AppointmentResponse> cancelAppointment(@PathVariable("id") UUID id) {
        deleteAppointmentsUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }


}
