package ru.anverbogatov.observability_research.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anverbogatov.observability_research.domain.DomainService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/messages", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MessageController {

    private final DomainService domainService;

    @GetMapping

    public List<String> getWelcomeMessage() {
        return domainService.getFullStatus();
    }

    @GetMapping("/completable")
    public List<String> getCompletableFutureWelcomeMessage() {
        return domainService.getFullStatusWithCompletableFuture();
    }
}
