package com.piresvet.usecase.Appointment;

import com.piresvet.core.domain.Appointments;

import java.util.List;
import java.util.UUID;

public interface FindAppointmentsUseCase {
    List<Appointments> findAll();
    Appointments findById(UUID id);
}
