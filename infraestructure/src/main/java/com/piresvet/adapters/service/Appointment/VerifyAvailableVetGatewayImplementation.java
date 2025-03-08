package com.piresvet.adapters.service.Appointment;

import com.piresvet.core.domain.Vet;
import com.piresvet.dataMapper.PetMapper;
import com.piresvet.dataMapper.PetOwnerMapper;
import com.piresvet.gatewayContracts.Appointments.VerifyAvailableVetGateway;
import com.piresvet.persistence.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class VerifyAvailableVetGatewayImplementation implements VerifyAvailableVetGateway {

    @Override
    public boolean verify(Vet vet) {
        return vet.getAvailable();
    }
}
