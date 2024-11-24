package com.piresvet.core.domain;

import com.piresvet.core.enums.Size;
import com.piresvet.core.enums.Species;

import java.time.LocalDate;
import java.util.UUID;

public class Pet {
    private UUID id;
    private String name;
    private Integer age;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private PetOwner petOwner;
    private Species species;
    private Size size;
    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Pet(String name, Integer age, LocalDate createdAt, LocalDate updatedAt, PetOwner petOwner, Species species, Size size) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.petOwner = petOwner;
        this.species = species;
        this.size = size;
        this.available = true;
    }

    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public PetOwner getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwner petOwner) {
        this.petOwner = petOwner;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

}
