package com.payment_system.service.interfaces;

import com.payment_system.dto.ChargeRequestDto;
import com.payment_system.dto.ChargeResponseDto;

public interface ChargeOperations {

    ChargeResponseDto createCharge(ChargeRequestDto body);
    void getCharge();
    void updateCharge();
    void deleteCharge();
}
