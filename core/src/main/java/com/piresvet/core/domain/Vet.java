package com.piresvet.core.domain;


import com.piresvet.core.validation.Validator;


import java.util.UUID;

public class Vet {
    private UUID id;
    private String firstname;
    private String lastname;
    private String crmv;

    public Vet(String firstname, String lastname, String crmv) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.crmv = crmv;
    }

    public Vet() {
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

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }



}
