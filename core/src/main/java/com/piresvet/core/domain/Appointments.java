package com.piresvet.core.domain;

import com.piresvet.core.enums.Services;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

public class Appointments {
    private UUID id;
    private BigInteger expected;
    private Services services;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Pet pet;
    private Vet vet;

    public Appointments(BigInteger expected, Services services, LocalDate createdAt, LocalDate updatedAt, Pet pet, Vet vet) {
        this.id = UUID.randomUUID();
        this.expected = expected;
        this.services = services;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.pet = pet;
        this.vet = vet;
    }

    public UUID getId() {
        return id;
    }

    public BigInteger getExpected() {
        return expected;
    }

    public void setExpected(BigInteger expected) {
        this.expected = expected;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}
