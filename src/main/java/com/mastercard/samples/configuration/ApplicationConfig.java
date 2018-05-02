package com.mastercard.samples.configuration;

import com.mastercard.samples.services.CardValidationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfig {

    @Bean
    public CardValidationService cardValidationService() {
        return new CardValidationService();
    }
}
