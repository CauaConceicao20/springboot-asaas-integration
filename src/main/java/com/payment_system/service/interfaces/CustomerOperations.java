package com.payment_system.service.interfaces;

import com.asaas.apisdk.models.CustomerListResponseDto;

import java.util.Set;

public interface CustomerOperations {

    Set<CustomerListResponseDto> getAllCustomer();
}
