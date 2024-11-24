package com.piresvet.usecase.Appointment;

import com.piresvet.core.domain.Appointments;

import java.util.UUID;

public interface UpdateAppointmentsUseCase {
    Appointments update(UUID id);
}
