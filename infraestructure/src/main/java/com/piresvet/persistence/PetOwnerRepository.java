package com.piresvet.persistence;

import com.piresvet.dataModel.PetOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PetOwnerRepository extends JpaRepository<PetOwnerEntity, UUID> {
}
