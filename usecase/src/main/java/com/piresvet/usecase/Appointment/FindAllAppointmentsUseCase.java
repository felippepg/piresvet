package com.piresvet.usecase.Appointment;

import com.piresvet.core.domain.Appointments;

import java.util.List;

public interface FindAllAppointmentsUseCase {
    List<Appointments> getAppointments();
}
