package com.piresvet.core.domain;


import com.piresvet.core.validation.Validator;


import java.util.UUID;

public class Vet {
    private UUID id;
    private String firstname;
    private String lastname;
    private String crmv;
    private Validator nameValidator;
    private Validator vetCrmvValidator;

    public Vet(String firstname, String lastname, String crmv, Validator nameValidator, Validator vetCrmvValidator) {
        this.id = UUID.randomUUID();
        this.nameValidator = nameValidator;
        this.vetCrmvValidator = vetCrmvValidator;
        setFirstname(firstname);
        setLastname(lastname);
        setCrmv(crmv);
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
        this.nameValidator.validate(firstname);
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.nameValidator.validate(lastname);
        this.lastname = lastname;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.vetCrmvValidator.validate(crmv);
        this.crmv = crmv;
    }



}
