package ru.anverbogatov.observability_research.infrastructure.integrations.clients;

import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class ServiceBClient {

    public String getText() {
        try {
            Thread.sleep(Duration.ofSeconds(10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Welcome B";
    }
}
