package com.payment_system.service.interfaces;

import com.payment_system.dto.PixKeyResponseDto;

import java.util.Set;

public interface PixOperations {

    PixKeyResponseDto createPixKey();
    Set<PixKeyResponseDto> getKeys();
}
