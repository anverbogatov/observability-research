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
}
