package com.piresvet.gateway.Appointments;

import com.piresvet.core.domain.Appointments;

import java.util.UUID;

public interface UpdateAppointmentsGateway {
    Appointments update(UUID id);
}
