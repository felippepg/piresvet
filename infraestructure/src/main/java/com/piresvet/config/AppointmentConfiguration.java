package com.piresvet.config;

import com.piresvet.gatewayContracts.Appointments.*;
import com.piresvet.useCaseContracts.Appointment.*;
import com.piresvet.useCaseImplementation.Appointment.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentConfiguration {
    @Bean
    public CreateAppointmentUseCase createAppointmentUseCase(CreateAppointmentGateway createAppointmentGateway, VerifyAvailablePetGateway verifyAvailablePetGateway, VerifyAvailableVetGateway verifyAvailableVetGateway) {
        return new CreateAppointmentUseCaseImpl(createAppointmentGateway, verifyAvailablePetGateway, verifyAvailableVetGateway);
    }

    @Bean
    public FindAppointmentsUseCase findAppointmentsUseCase(FindAppointmentsGateway findAppointmentsGateway) {
        return new FindAppointmentsUseCaseImpl(findAppointmentsGateway);
    }

    @Bean
    public UpdateAppointmentsUseCase updateAppointmentsUseCase(UpdateAppointmentsGateway updateAppointmentsGateway, FindAppointmentsGateway findAppointmentsGateway) {
        return new UpdateAppointmentsUseCaseImpl(updateAppointmentsGateway, findAppointmentsGateway);
    }

    @Bean
    public DeleteAppointmentsUseCase deleteAppointmentsUseCase(DeleteAppointmentsGateway deleteAppointmentsGateway, FindAppointmentsGateway findAppointmentsGateway) {
        return new DeleteAppointmentsUseCaseImpl(deleteAppointmentsGateway, findAppointmentsGateway);
    }

    @Bean
    public FinishedAppointmentsUseCase finishedAppointmentsUseCase(FinishedAppointmentsGateway finishedAppointmentsGateway, FindAppointmentsGateway findAppointmentsGateway) {
        return new FinishedAppointmentsUseCaseImpl(finishedAppointmentsGateway, findAppointmentsGateway);
    }
}
