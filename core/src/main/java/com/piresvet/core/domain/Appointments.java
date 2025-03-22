package com.piresvet.core.domain;

import com.piresvet.core.enums.Services;

import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

public class Appointments {
    private UUID id;
    private BigInteger expected;
    private Services services;
    private Date createdAt;
    private Date updatedAt;
    private Pet pet;
    private Vet vet;

    public Appointments(BigInteger expected, Services services, Date createdAt, Date updatedAt, Pet pet, Vet vet) {
        this.id = UUID.randomUUID();
        this.expected = expected;
        this.services = services;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.pet = pet;
        this.vet = vet;
    }

    public Appointments(UUID id, BigInteger expected, Services services, Date createdAt, Date updatedAt, Pet pet, Vet vet) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
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
