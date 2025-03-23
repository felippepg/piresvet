package com.piresvet.persistence;

import com.piresvet.dataModel.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, UUID> {
    List<AppointmentEntity> findByPet_PetOwner_Cpf(String cpf);

}
