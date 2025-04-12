package com.piresvet.adapters.inbound.controller;

import com.piresvet.adapters.inbound.dtos.Appointment.AppointmentRequest;
import com.piresvet.adapters.inbound.dtos.Appointment.AppointmentResponse;
import com.piresvet.adapters.helpers.AppointmentHelper;
import com.piresvet.dataMapper.AppointmentMapper;
import com.piresvet.useCaseContracts.Appointment.*;
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
    private final FindAppointmentsUseCase findAppointmentsUseCase;
    private final UpdateAppointmentsUseCase updateAppointmentsUseCase;
    private final DeleteAppointmentsUseCase deleteAppointmentsUseCase;
    private final FinishedAppointmentsUseCase finishedAppointmentsUseCase;
    private final AppointmentMapper appointmentMapper;
    private final AppointmentHelper appointmentHelper;

    @PostMapping("/create")
    public ResponseEntity<AppointmentResponse> createVet(@RequestBody AppointmentRequest request) {
        appointmentHelper.validate(request);
        var appointment = appointmentHelper.generate(request);
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
    public ResponseEntity<AppointmentResponse> updateAppointment(@PathVariable("id") UUID id, @RequestBody AppointmentRequest request) {
        appointmentHelper.validate(request);
        var appointment = appointmentHelper.generate(request);
        var response = updateAppointmentsUseCase.update(id, appointment);
        return ResponseEntity.ok(appointmentMapper.toResponse(response));
    }

    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<AppointmentResponse> cancelAppointment(@PathVariable("id") UUID id) {
        deleteAppointmentsUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/finished/{id}")
    public ResponseEntity<AppointmentResponse> finishedAppoint(@PathVariable("id") UUID id) {
        var appointment = finishedAppointmentsUseCase.finished(id);
        return ResponseEntity.ok().body(appointmentMapper.toResponse(appointment));
    }


}
