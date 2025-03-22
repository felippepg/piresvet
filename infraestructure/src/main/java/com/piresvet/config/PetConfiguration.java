package com.piresvet.config;

import com.piresvet.gatewayContracts.Pet.CreatePetGateway;
import com.piresvet.gatewayContracts.Pet.DeletePetGateway;
import com.piresvet.gatewayContracts.Pet.FindPetsGateway;
import com.piresvet.gatewayContracts.Pet.UpdatePetGateway;
import com.piresvet.gatewayContracts.PetOwner.FindPetOwnerGateway;
import com.piresvet.useCaseContracts.Pet.CreatePetUseCase;
import com.piresvet.useCaseContracts.Pet.DeletePetUseCase;
import com.piresvet.useCaseContracts.Pet.FindPetsUseCase;
import com.piresvet.useCaseContracts.Pet.UpdatePetUseCase;
import com.piresvet.useCaseImplementation.Pet.CreatePetUseCaseImpl;
import com.piresvet.useCaseImplementation.Pet.DeletePetUseCaseImpl;
import com.piresvet.useCaseImplementation.Pet.FindPetsUseCaseImpl;
import com.piresvet.useCaseImplementation.Pet.UpdatePetUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetConfiguration {
    @Bean
    public CreatePetUseCase createPetUseCase(CreatePetGateway gateway) {
        return new CreatePetUseCaseImpl(gateway);
    }

    @Bean
    public FindPetsUseCase findPetsUseCase(FindPetsGateway gateway, FindPetOwnerGateway petOwnerGateway) {
        return new FindPetsUseCaseImpl(gateway, petOwnerGateway);
    }

    @Bean
    public UpdatePetUseCase updatePetUseCase(UpdatePetGateway gateway) {
        return new UpdatePetUseCaseImpl(gateway);
    }

    @Bean
    public DeletePetUseCase deletePetUseCase(DeletePetGateway gateway) {
        return new DeletePetUseCaseImpl(gateway);
    }

}
