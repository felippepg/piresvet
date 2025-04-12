package com.piresvet.adapters.service.Pet;

import com.piresvet.gatewayContracts.Pet.DeletePetGateway;
import com.piresvet.persistence.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class DeletePetGatewayImplementation implements DeletePetGateway {
    private final PetRepository petRepository;

    @Override
    public void delete(UUID id) {
        var pet = petRepository.findById(id);
        petRepository.delete(pet.get());
    }
}
