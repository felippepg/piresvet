package com.piresvet.useCaseContracts.Appointment;

import com.piresvet.core.domain.Appointments;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FindAppointmentsUseCase {
    List<Appointments> findAll();
    Appointments findById(UUID id);

    List<Appointments> findByCpfOwner(String cpf);

}
