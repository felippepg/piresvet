package com.piresvet.gatewayContracts.Appointments;

import com.piresvet.core.domain.Appointments;

public interface CreateAppointmentGateway {
    Appointments create(Appointments appointment);
}
