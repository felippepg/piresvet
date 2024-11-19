package com.piresvet.core.domain;


import java.util.UUID;

public class PetOwner {
    private UUID id;
    private String firstname;
    private String lastname;
    private String cpf;

    public PetOwner(String firstname, String lastname, String cpf) {
        this.id = UUID.randomUUID();
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
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String crmv) {
        this.cpf = cpf;
    }



}
