package com.payment_system.service.interfaces;

import com.asaas.apisdk.models.*;

import java.util.Set;

public interface ChargeOperations {

    PaymentGetResponseDto createPayment(PaymentSaveRequestDto body);
    Set<PaymentListResponseDto> getAllCharge();
}
