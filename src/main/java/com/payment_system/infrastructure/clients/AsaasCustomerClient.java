package com.payment_system.infrastructure.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment_system.dto.CustomerResponseDto;
import com.payment_system.service.interfaces.CustomerOperations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Set;

@Component
public class AsaasCustomerClient implements CustomerOperations {

    @Value("${asaas.api.token.prod}")
    private String asaasToken;

    private final ObjectMapper objectMapper;

    public AsaasCustomerClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Set<CustomerResponseDto> getAllCustomer() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.asaas.com/v3/customers"))
                    .header("accept", "application/json")
                    .header("User-Agent", "payment_system/1.0.0")
                    .header("access_token", asaasToken)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() != 200) {
                throw new RuntimeException("Falha ao buscar clientes " + response.body());
            }

            return Set.of(objectMapper.readValue(response.body(), CustomerResponseDto.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
