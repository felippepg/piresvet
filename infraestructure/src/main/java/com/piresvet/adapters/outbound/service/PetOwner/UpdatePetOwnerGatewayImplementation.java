package com.piresvet.adapters.outbound.service.PetOwner;

import com.piresvet.core.domain.PetOwner;
import com.piresvet.gatewayContracts.PetOwner.UpdatePetOwnerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class UpdatePetOwnerGatewayImplementation implements UpdatePetOwnerGateway {
    @Override
    public PetOwner update(UUID id) {
        return null;
    }
}
