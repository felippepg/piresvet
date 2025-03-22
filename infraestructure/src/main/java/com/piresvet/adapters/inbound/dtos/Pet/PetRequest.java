package com.piresvet.adapters.inbound.dtos.Pet;

import com.piresvet.core.enums.Size;
import com.piresvet.core.enums.Species;

import java.util.UUID;

public record PetRequest(String name, Integer age, Size size, Species species, UUID owner) {
}