package com.payment_system.infrastructure.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment_system.dto.ChargeRequestDto;
import com.payment_system.dto.ChargeResponseDto;
import com.payment_system.dto.QrCodePixRequestDto;
import com.payment_system.dto.QrCodePixResponseDto;
import com.payment_system.infrastructure.config.JacksonConfig;
import com.payment_system.service.interfaces.ChargeOperations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Set;

@Component
public class AsaasChargeClient implements ChargeOperations {

    @Value("${asaas.api.token.prod}")
    private String asaasToken;

    private final ObjectMapper objectMapper;

    public AsaasChargeClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public ChargeResponseDto createCharge(ChargeRequestDto body) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.asaas.com/v3/payments"))
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
    public QrCodePixResponseDto createQrCodePixStatic(QrCodePixRequestDto body) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.asaas.com/v3/pix/qrCodes/static"))
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

            return objectMapper.readValue(response.body(), QrCodePixResponseDto.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<ChargeResponseDto> getAllCharge() {
        try {
            HttpRequest request = HttpRequest.newBuilder().
                    uri(URI.create("https://api.asaas.com/v3/payments"))
                    .header("User-Agent", "payment_system/1.0.0")
                    .header("accept", "application/json")
                    .header("access_token", asaasToken)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() != 200) {
                throw new RuntimeException("Falha ao buscar cobrança " + response.body());
            }

           return Set.of(objectMapper.readValue(response.body(), ChargeResponseDto.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCharge() {

    }

    @Override
    public void deleteCharge() {

    }
}
