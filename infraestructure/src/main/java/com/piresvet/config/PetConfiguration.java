package com.piresvet.config;

import com.piresvet.gatewayContracts.Pet.CreatePetGateway;
import com.piresvet.useCaseContracts.Pet.CreatePetUseCase;
import com.piresvet.useCaseImplementation.Pet.CreatePetUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetConfiguration {
    @Bean
    public CreatePetUseCase createPetUseCase(CreatePetGateway gateway) {
        return new CreatePetUseCaseImpl(gateway);
    }

}
