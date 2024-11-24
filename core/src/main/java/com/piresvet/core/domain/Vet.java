package com.piresvet.core.domain;


import com.piresvet.core.domain.valueobjects.Crmv;
import com.piresvet.core.domain.valueobjects.Name;



import java.util.UUID;

public class Vet {
    private UUID id;
    private Name firstname;
    private Name lastname;
    private Crmv crmv;

    private Boolean available;

    public Vet(Name firstname, Name lastname, Crmv crmv) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.crmv = crmv;
        this.available = true;
    }

    public Vet() {
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

    public String getCrmv() {
        return crmv.getCrmv();
    }

    public void setCrmv(Crmv crmv) {
        this.crmv = crmv;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
