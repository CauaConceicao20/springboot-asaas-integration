package com.payment_system.infrastructure.config;
import com.asaas.apisdk.AsaasSdk;
import com.asaas.apisdk.config.ApiKeyAuthConfig;
import com.asaas.apisdk.config.AsaasSdkConfig;
import com.asaas.apisdk.http.Environment;

import com.asaas.apisdk.services.CustomerService;
import com.asaas.apisdk.services.PaymentService;
import com.asaas.apisdk.services.PixService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AsaasConfig {

    @Value("${asaas.api.token.prod}")
    private String asaasApiKey;

    @Bean
    public AsaasSdk asaasSdk() {
        AsaasSdkConfig config = AsaasSdkConfig.builder()
                .apiKeyAuthConfig(ApiKeyAuthConfig.builder().apiKey(asaasApiKey).build())
                .build();

        config.setEnvironment(Environment.PRODUCTION);

        return new AsaasSdk(config);
    }

    @Bean
    public PaymentService PaymentService(AsaasSdk asaasSdk) {
        return asaasSdk.payment;
    }

    @Bean
    public PixService PixKeysService(AsaasSdk asaasSdk) {
        return asaasSdk.pix;
    }

    @Bean
    public CustomerService CustomerService(AsaasSdk asaasSdk) {
        return asaasSdk.customer;
    }

}