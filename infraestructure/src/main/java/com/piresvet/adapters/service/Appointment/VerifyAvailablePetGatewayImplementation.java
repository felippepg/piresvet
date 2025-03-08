package com.piresvet.adapters.service.Appointment;

import com.piresvet.core.domain.Pet;
import com.piresvet.dataMapper.PetMapper;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.gatewayContracts.Appointments.VerifyAvailablePetGateway;
import com.piresvet.persistence.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class VerifyAvailablePetGatewayImplementation implements VerifyAvailablePetGateway {
    @Override
    public boolean verify(Pet pet) {
        return pet.isAvailable();
    }
}
