package com.payment_system.service;

import com.payment_system.dto.ChargeListResponseDto;
import com.payment_system.dto.ChargeRequestDto;
import com.payment_system.dto.ChargeResponseDto;
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

    public ChargeResponseDto createCharge(ChargeRequestDto body) {
        ChargeResponseDto response = chargeOperations.createCharge(body);
        qrCodeConverter.generateQrCodeImage(response.encodedImage(), response.id());
        return response;
    }

    public Set<ChargeListResponseDto> getAllCharge() {
        return chargeOperations.getAllCharge();
    }

}
