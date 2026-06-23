package com.payment_system.service.interfaces;

import com.payment_system.dto.ChargeListResponseDto;
import com.payment_system.dto.ChargeRequestDto;
import com.payment_system.dto.ChargeResponseDto;

import java.util.Set;

public interface ChargeOperations {

    ChargeResponseDto createCharge(ChargeRequestDto body);
    Set<ChargeListResponseDto> getAllCharge();
    void updateCharge();
    void deleteCharge();
}
