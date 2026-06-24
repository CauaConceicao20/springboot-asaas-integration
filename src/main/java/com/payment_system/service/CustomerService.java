package com.payment_system.service;

import com.payment_system.dto.CustomerResponseDto;
import com.payment_system.infrastructure.clients.AsaasCustomerClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class CustomerService {

    private final AsaasCustomerClient asaasCustomerClient;

    public Set<CustomerResponseDto> getAllCustomer() {
        return asaasCustomerClient.getAllCustomer();
    }
}
