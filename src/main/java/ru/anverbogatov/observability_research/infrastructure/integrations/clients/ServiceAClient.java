package ru.anverbogatov.observability_research.infrastructure.integrations.clients;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

@Component
public class ServiceAClient {

    public String getMessage() {
        try {
            Thread.sleep(Duration.ofSeconds(10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Welcome A";
    }
}
