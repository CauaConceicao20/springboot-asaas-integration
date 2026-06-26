package com.payment_system.service;

import com.asaas.apisdk.models.*;
import com.payment_system.infrastructure.utils.QrCodeConverter;
import com.payment_system.service.interfaces.ChargeOperations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class ChargeService {

    private final ChargeOperations chargeOperations;
    private final QrCodeConverter qrCodeConverter;

    public PaymentGetResponseDto createCharge(PaymentSaveRequestDto body) {
        return chargeOperations.createPayment(body);
    }


    public Set<PaymentListResponseDto> getAllCharge() {
        return chargeOperations.getAllCharge();
    }


}
