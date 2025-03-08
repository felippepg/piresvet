package com.piresvet.config;

import com.piresvet.gatewayContracts.Appointments.CreateAppointmentGateway;
import com.piresvet.gatewayContracts.Appointments.VerifyAvailablePetGateway;
import com.piresvet.gatewayContracts.Appointments.VerifyAvailableVetGateway;
import com.piresvet.useCaseContracts.Appointment.CreateAppointmentUseCase;
import com.piresvet.useCaseImplementation.Appointment.CreateAppointmentUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentConfiguration {
    @Bean
    public CreateAppointmentUseCase createAppointmentUseCase(CreateAppointmentGateway createAppointmentGateway, VerifyAvailablePetGateway verifyAvailablePetGateway, VerifyAvailableVetGateway verifyAvailableVetGateway) {
        return new CreateAppointmentUseCaseImpl(createAppointmentGateway, verifyAvailablePetGateway, verifyAvailableVetGateway);
    }
}
