package com.payment_system.service;

import com.asaas.apisdk.models.CustomerListResponseDto;
import com.payment_system.infrastructure.clients.AsaasCustomerClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class CustomerService {

    private final AsaasCustomerClient asaasCustomerClient;

    public Set<CustomerListResponseDto> getAllCustomer() {
        return asaasCustomerClient.getAllCustomer();
    }
}
