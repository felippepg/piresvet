package com.piresvet.core.domain;


import com.piresvet.core.domain.valueobjects.Cpf;
import com.piresvet.core.domain.valueobjects.Name;

import java.util.UUID;

public class PetOwner {
    private UUID id;
    private Name firstname;
    private Name lastname;
    private Cpf cpf;

    public PetOwner(Name firstname, Name lastname, Cpf cpf) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.cpf = cpf;
    }

    public PetOwner(UUID id, Name firstname, Name lastname, Cpf cpf) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.cpf = cpf;
    }

    public PetOwner() {
    }

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname.getName();
    }

    public void setFirstname(Name firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname.getName();
    }

    public void setLastname(Name lastname) {
        this.lastname = lastname;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }



}
