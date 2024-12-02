package com.piresvet.config;

import com.piresvet.core.factory.VetFactory;
import com.piresvet.gatewayContracts.Vet.CreateVetGateway;
import com.piresvet.gatewayContracts.Vet.FindVetGateway;
import com.piresvet.useCaseContracts.Vet.CreateVetUseCase;
import com.piresvet.useCaseContracts.Vet.FindVetUseCase;
import com.piresvet.useCaseImplementation.Vet.CreateVetUseCaseImpl;
import com.piresvet.useCaseImplementation.Vet.FindVetUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VetConfiguration {

    @Bean
    public CreateVetUseCase createVetUseCase(CreateVetGateway createVetGateway) {
        return new CreateVetUseCaseImpl(createVetGateway);
    }

    @Bean
    public FindVetUseCase findVetUseCase(FindVetGateway findVetGateway) {
        return new FindVetUseCaseImpl(findVetGateway);
    }

    @Bean
    public VetFactory vetFactory() {
        return new VetFactory();
    }

}
