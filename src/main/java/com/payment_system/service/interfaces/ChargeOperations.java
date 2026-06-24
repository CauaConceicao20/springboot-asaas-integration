package com.payment_system.service.interfaces;

import com.payment_system.dto.ChargeRequestDto;
import com.payment_system.dto.ChargeResponseDto;
import com.payment_system.dto.QrCodePixRequestDto;
import com.payment_system.dto.QrCodePixResponseDto;

import java.util.Set;

public interface ChargeOperations {

    ChargeResponseDto createCharge(ChargeRequestDto body);
    QrCodePixResponseDto createQrCodePixStatic(QrCodePixRequestDto body);
    Set<ChargeResponseDto> getAllCharge();
    void updateCharge();
    void deleteCharge();
}
