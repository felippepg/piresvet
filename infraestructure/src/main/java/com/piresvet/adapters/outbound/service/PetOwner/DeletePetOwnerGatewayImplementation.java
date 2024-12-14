package com.piresvet.adapters.outbound.service.PetOwner;

import com.piresvet.gatewayContracts.PetOwner.DeletePetOwnerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class DeletePetOwnerGatewayImplementation implements DeletePetOwnerGateway {
    @Override
    public void delete(UUID id) {

    }
}
