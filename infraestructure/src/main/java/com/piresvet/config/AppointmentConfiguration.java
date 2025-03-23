package com.piresvet.config;

import com.piresvet.gatewayContracts.Appointments.*;
import com.piresvet.useCaseContracts.Appointment.CreateAppointmentUseCase;
import com.piresvet.useCaseContracts.Appointment.FindAppointmentsUseCase;
import com.piresvet.useCaseContracts.Appointment.UpdateAppointmentsUseCase;
import com.piresvet.useCaseImplementation.Appointment.CreateAppointmentUseCaseImpl;
import com.piresvet.useCaseImplementation.Appointment.FindAppointmentsUseCaseImpl;
import com.piresvet.useCaseImplementation.Appointment.UpdateAppointmentsUseCaseImpl;
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
}
