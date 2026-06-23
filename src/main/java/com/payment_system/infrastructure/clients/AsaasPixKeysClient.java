package com.payment_system.infrastructure.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment_system.dto.PixKeyResponseDto;
import com.payment_system.service.interfaces.PixOperations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Set;

@Component
public class AsaasPixKeysClient implements PixOperations {

    @Value("${asaas.api.token.prod}")
    private String asaasToken;

    private final ObjectMapper objectMapper;

    public AsaasPixKeysClient() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public PixKeyResponseDto createPixKey() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.asaas.com/v3/pix/addressKeys"))
                    .header("accept", "application/json")
                    .header("User-Agent", "payment_system/1.0.0")
                    .header("content-type", "application/json")
                    .header("access_token", asaasToken)
                    .header("token", "000000")
                    .method("POST", HttpRequest.BodyPublishers.ofString("{\"type\":\"EVP\"}"))
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());

            return objectMapper.readValue(
                    response.body(), PixKeyResponseDto.class
            );
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<PixKeyResponseDto> getKeys() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.asaas.com/v3/pix/addressKeys"))
                    .header("accept", "application/json")
                    .header("User-Agent", "payment_system/1.0.0")
                    .header("access_token", asaasToken)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());


            return Set.of(objectMapper.readValue(
                    response.body(), PixKeyResponseDto.class));

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

