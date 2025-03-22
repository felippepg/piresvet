package com.piresvet.adapters.inbound.dtos.Appointment;

import com.piresvet.adapters.inbound.dtos.Pet.PetResponse;
import com.piresvet.adapters.inbound.dtos.Vet.VetResponse;
import com.piresvet.core.enums.Services;

import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

public record AppointmentResponse(UUID id, BigInteger expected, Services services, Date created_at, Date updated_at, PetResponse pet, VetResponse vet) {
}
