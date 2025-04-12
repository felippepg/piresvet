package com.piresvet.useCaseImplementation.Pet;

import com.piresvet.core.domain.Pet;
import com.piresvet.core.exception.InvalidPetException;
import com.piresvet.gatewayContracts.Pet.CreatePetGateway;
import com.piresvet.useCaseContracts.Pet.CreatePetUseCase;

public class CreatePetUseCaseImpl implements CreatePetUseCase {
    private final CreatePetGateway createPetGateway;

    public CreatePetUseCaseImpl(CreatePetGateway createPetGateway) {
        this.createPetGateway = createPetGateway;
    }

    @Override
    public Pet create(Pet pet) {
        if(pet.getName() == null) {
            throw new InvalidPetException("Não é possivel criar um pet sem nome!");
        }
        if(pet.getAge() == null) {
            throw new InvalidPetException("Não é possivel criar um pet sem idade!");
        }
        if(pet.getSpecies() == null) {
            throw new InvalidPetException("Não é possivel criar um pet sem espécie!");
        }
        return createPetGateway.create(pet);
    }
}
