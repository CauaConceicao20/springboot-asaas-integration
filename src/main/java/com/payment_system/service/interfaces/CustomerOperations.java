package com.payment_system.service.interfaces;

import com.payment_system.dto.CustomerResponseDto;

import java.util.Set;

public interface CustomerOperations {

    Set<CustomerResponseDto> getAllCustomer();
}
