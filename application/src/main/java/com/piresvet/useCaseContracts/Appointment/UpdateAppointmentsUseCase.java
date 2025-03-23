package com.piresvet.useCaseContracts.Appointment;

import com.piresvet.core.domain.Appointments;

import java.util.UUID;

public interface UpdateAppointmentsUseCase {
    Appointments update(UUID id, Appointments appointments);
}
