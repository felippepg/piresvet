package com.piresvet.dataModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Vet")
public class VetEntity {
    @Column(name = "Id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 100)
    private String firstname;
    @Column(nullable = false, length = 100)
    private String lastname;
    @Column(nullable = false, length = 8)
    private String crmv;
    private Boolean available;

}
