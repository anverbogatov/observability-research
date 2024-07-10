package ru.anverbogatov.observability_research.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anverbogatov.observability_research.infrastructure.integrations.clients.ServiceAClient;
import ru.anverbogatov.observability_research.infrastructure.integrations.clients.ServiceBClient;
import ru.anverbogatov.observability_research.infrastructure.integrations.clients.ServiceCClient;
import ru.anverbogatov.observability_research.infrastructure.integrations.clients.ServiceDClient;
import ru.anverbogatov.observability_research.infrastructure.integrations.clients.ServiceEClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class DomainService {

    private final ServiceAClient serviceAClient;
    private final ServiceBClient serviceBClient;
    private final ServiceCClient serviceCClient;
    private final ServiceDClient serviceDClient;
    private final ServiceEClient serviceEClient;

    public List<String> getFullStatus() {
        var result = new ArrayList<String>();

        result.add(serviceAClient.getMessage());
        result.add(serviceBClient.getText());
        result.add(serviceCClient.getNote());
        result.add(serviceDClient.getWelcome());
        result.add(serviceEClient.getFinalInfo());

        return result;
    }

    public List<String> getFullStatusWithCompletableFuture() {
        var result = new ArrayList<String>();

        CompletableFuture.allOf(
                CompletableFuture.supplyAsync(serviceAClient::getMessage).thenAccept(result::add),
                CompletableFuture.supplyAsync(serviceBClient::getText).thenAccept(result::add),
                CompletableFuture.supplyAsync(serviceCClient::getNote).thenAccept(result::add),
                CompletableFuture.supplyAsync(serviceDClient::getWelcome).thenAccept(result::add),
                CompletableFuture.supplyAsync(serviceEClient::getFinalInfo).thenAccept(result::add)
        ).join();

        return result;
    }
}
