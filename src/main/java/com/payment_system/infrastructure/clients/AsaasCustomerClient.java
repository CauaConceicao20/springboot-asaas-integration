package com.payment_system.infrastructure.clients;

import com.asaas.apisdk.models.CustomerListResponseDto;
import com.asaas.apisdk.services.CustomerService;
import com.payment_system.service.interfaces.CustomerOperations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
public class AsaasCustomerClient implements CustomerOperations {


    private final CustomerService customerService;

    @Override
    public Set<CustomerListResponseDto> getAllCustomer() {
        return Set.of(customerService.listCustomers());
    }
}
