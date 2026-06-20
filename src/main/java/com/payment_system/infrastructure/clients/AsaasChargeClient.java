package com.payment_system.infrastructure.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment_system.dto.ChargeRequestDto;
import com.payment_system.dto.ChargeResponseDto;
import com.payment_system.service.interfaces.ChargeOperations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class AsaasChargeClient implements ChargeOperations {

    @Value("${asaas.api.token}")
    private String asaasToken;

    private final ObjectMapper objectMapper;

    public AsaasChargeClient() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public ChargeResponseDto createCharge(ChargeRequestDto body) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-sandbox.asaas.com/v3/pix/qrCodes/static"))
                    .header("User-Agent", "payment_system/1.0.0")
                    .header("accept", "application/json")
                    .header("content-type", "application/json")
                    .header("access_token", asaasToken)
                    .method("POST", HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(body)))
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() != 200) {
                throw new RuntimeException("Falha ao criar cobrança " + response.body());
            }

            return objectMapper.readValue(response.body(), ChargeResponseDto.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getCharge() {

    }

    @Override
    public void updateCharge() {

    }

    @Override
    public void deleteCharge() {

    }
}
