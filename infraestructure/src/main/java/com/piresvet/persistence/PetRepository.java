package com.piresvet.persistence;

import com.piresvet.dataModel.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PetRepository extends JpaRepository<PetEntity, UUID> {
}
