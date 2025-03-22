package com.piresvet.persistence;

import com.piresvet.dataModel.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PetRepository extends JpaRepository<PetEntity, UUID> {
    @Query("SELECT p FROM PetEntity p JOIN p.petOwner o WHERE o.cpf = :cpf")
    List<PetEntity> findByPetOwnerCpf(@Param("cpf") String cpf);
}
