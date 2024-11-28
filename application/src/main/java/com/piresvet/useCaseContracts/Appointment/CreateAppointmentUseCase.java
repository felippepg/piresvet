package com.piresvet.useCaseContracts.Appointment;

import com.piresvet.core.domain.Appointments;

public interface CreateAppointmentUseCase {
    Appointments create(Appointments appointment);
}
