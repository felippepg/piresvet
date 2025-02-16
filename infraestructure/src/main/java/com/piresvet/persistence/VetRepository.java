package com.piresvet.persistence;

import com.piresvet.dataModel.PetOwnerEntity;
import com.piresvet.dataModel.VetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VetRepository extends JpaRepository<VetEntity, UUID> {
    Optional<VetEntity> findByCrmv(String crmv);
    List<VetEntity> findByAvailableTrue();
    List<VetEntity> findByFirstnameIgnoreCaseAndLastnameIgnoreCase(String firstname, String lastname);
    List<VetEntity> findByFirstnameIgnoreCase(String firstname);



}
