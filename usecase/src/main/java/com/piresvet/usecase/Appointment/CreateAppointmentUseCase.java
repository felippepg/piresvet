package com.piresvet.usecase.Appointment;

import com.piresvet.core.domain.Appointments;

public interface CreateAppointmentUseCase {
    Appointments create(Appointments appointment);
}
