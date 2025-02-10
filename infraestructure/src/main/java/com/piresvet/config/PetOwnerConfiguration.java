package com.piresvet.config;

import com.piresvet.core.factory.PetOwnerFactory;
import com.piresvet.gatewayContracts.PetOwner.CreatePetOwnerGateway;
import com.piresvet.gatewayContracts.PetOwner.DeletePetOwnerGateway;
import com.piresvet.gatewayContracts.PetOwner.FindPetOwnerGateway;
import com.piresvet.gatewayContracts.PetOwner.UpdatePetOwnerGateway;
import com.piresvet.useCaseContracts.PetOwner.CreatePetOwnerUseCase;
import com.piresvet.useCaseContracts.PetOwner.DeletePetOwnerUseCase;
import com.piresvet.useCaseContracts.PetOwner.FindPetOwnerUseCase;
import com.piresvet.useCaseContracts.PetOwner.UpdatePetOwnerUseCase;
import com.piresvet.useCaseImplementation.PetOwner.CreatePetOwnerUseCaseImpl;
import com.piresvet.useCaseImplementation.PetOwner.DeletePetOwnerUseCaseImpl;
import com.piresvet.useCaseImplementation.PetOwner.FindPetOwnerUseCaseImpl;
import com.piresvet.useCaseImplementation.PetOwner.UpdatePetOwnerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetOwnerConfiguration {
    @Bean
    public CreatePetOwnerUseCase createPetOwnerUseCase(CreatePetOwnerGateway createPetOwnerGateway){
        return new CreatePetOwnerUseCaseImpl(createPetOwnerGateway);
    }

    @Bean
    public FindPetOwnerUseCase findPetOwnerUseCase(FindPetOwnerGateway findPetOwnerGateway) {
        return new FindPetOwnerUseCaseImpl(findPetOwnerGateway);
    }

    @Bean
    public UpdatePetOwnerUseCase updatePetOwnerUseCase(FindPetOwnerGateway findPetOwnerGateway, UpdatePetOwnerGateway updatePetOwnerGateway){
        return new UpdatePetOwnerUseCaseImpl(findPetOwnerGateway, updatePetOwnerGateway);
    }

    @Bean
    public DeletePetOwnerUseCase deletePetOwnerUseCase(FindPetOwnerGateway findPetOwnerGateway, DeletePetOwnerGateway deletePetOwnerGateway){
        return new DeletePetOwnerUseCaseImpl(findPetOwnerGateway, deletePetOwnerGateway);
    }

    @Bean
    public PetOwnerFactory petOwnerFactory() {
        return new PetOwnerFactory();
    }

}
