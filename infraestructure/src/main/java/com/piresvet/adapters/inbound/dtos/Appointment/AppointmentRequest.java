package com.piresvet.adapters.inbound.dtos.Appointment;

import com.piresvet.core.enums.Services;

import java.math.BigInteger;
import java.util.UUID;

public record AppointmentRequest(UUID pet, UUID vet, BigInteger expected, Services services) {
}
