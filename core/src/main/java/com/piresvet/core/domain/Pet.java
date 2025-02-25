package com.piresvet.core.domain;

import com.piresvet.core.enums.Size;
import com.piresvet.core.enums.Species;

import java.sql.Date;
import java.util.UUID;

public class Pet {
    private UUID id;
    private String name;
    private Integer age;
    private Date createdAt;
    private Date updatedAt;
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

    public Pet(String name, Integer age, Date createdAt, Date updatedAt, PetOwner petOwner, Species species, Size size) {
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

    public Pet(UUID id, String name, Integer age, Date createdAt, Date updatedAt, PetOwner petOwner, Species species, Size size) {
        this.id = id;
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
