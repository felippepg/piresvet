package com.piresvet.dataModel;
import com.piresvet.core.enums.Services;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Appointment")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "expected", nullable = false)
    private BigInteger expected;

    @Enumerated(EnumType.STRING)
    private Services services;

    @Column(name = "created_at", nullable = true)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private VetEntity vet;

    @Column(name = "size", length = 45)
    private String size;

    @Column(name = "is_finished")
    private Boolean isFinished;

    @PrePersist
    public void prePersist() {
        java.sql.Date now = java.sql.Date.valueOf(LocalDate.now());
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = java.sql.Date.valueOf(LocalDate.now());
    }

}
