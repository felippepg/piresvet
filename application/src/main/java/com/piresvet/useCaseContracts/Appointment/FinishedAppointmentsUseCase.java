package com.piresvet.useCaseContracts.Appointment;

import com.piresvet.core.domain.Appointments;

import java.util.UUID;

public interface FinishedAppointmentsUseCase {
    Appointments finished(UUID id);
}
