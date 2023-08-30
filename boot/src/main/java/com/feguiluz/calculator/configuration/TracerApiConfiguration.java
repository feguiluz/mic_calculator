package com.feguiluz.calculator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;

@Configuration
public class TracerApiConfiguration {
    
    @Bean(name = "tracer")
    public TracerImpl tracerApi() {
        return new TracerImpl();
    }

}
