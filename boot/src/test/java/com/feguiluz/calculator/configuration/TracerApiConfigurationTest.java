package com.feguiluz.calculator.configuration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import io.corp.calculator.TracerImpl;

@ExtendWith(MockitoExtension.class)
class TracerApiConfigurationTest {

    private final TracerApiConfiguration tracerApiConfiguration = new TracerApiConfiguration();

    @Test
    @DisplayName("Given TracerApiConfiguration when tracerApi is called then TracerImpl is returned")
    void given_tracer_api_configuration_when_tracer_api_is_called_then_tracer_impl_is_returned() {
        assertThat(tracerApiConfiguration.tracerApi(), is(instanceOf(TracerImpl.class)));
    }

    
}
