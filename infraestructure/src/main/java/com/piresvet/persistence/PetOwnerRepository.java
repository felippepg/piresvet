package com.piresvet.persistence;

import com.piresvet.dataModel.PetOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PetOwnerRepository extends JpaRepository<PetOwnerEntity, UUID> {
    Optional<PetOwnerEntity> findByCpf(String cpf);

    List<PetOwnerEntity> findByFirstnameAndLastname(String firstname, String lastname);

    List<PetOwnerEntity> findByFirstname(String firstname);
}
