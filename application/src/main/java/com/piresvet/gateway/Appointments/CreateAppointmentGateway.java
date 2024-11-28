package com.piresvet.gateway.Appointments;

import com.piresvet.core.domain.Appointments;

public interface CreateAppointmentGateway {
    Appointments create(Appointments appointment);
}
