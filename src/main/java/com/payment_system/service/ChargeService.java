package com.payment_system.service;

import com.payment_system.dto.ChargeRequestDto;
import com.payment_system.dto.ChargeResponseDto;
import com.payment_system.service.interfaces.ChargeOperations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChargeService {

    private final ChargeOperations chargeOperations;

    public ChargeResponseDto createCharge(ChargeRequestDto body) {
        return chargeOperations.createCharge(body);
    }

}
