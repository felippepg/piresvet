package com.piresvet.gatewayContracts.Appointments;

import com.piresvet.core.domain.Appointments;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FindAppointmentsGateway {
    List<Appointments> findAll();
    Optional<Appointments> findById(UUID id);
}
