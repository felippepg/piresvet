package com.piresvet.gatewayContracts.Appointments;

import com.piresvet.core.domain.Appointments;

import java.util.UUID;

public interface FinishedAppointmentsGateway {
    Appointments finished(UUID id);
}
