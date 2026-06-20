package com.payment_system.service;

import com.payment_system.dto.PixKeyResponseDto;
import com.payment_system.service.interfaces.PixOperations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class PixKeysService {

    private final PixOperations pixOperations;

    public PixKeyResponseDto createPixKey() {
       return pixOperations.createPixKey();
    }

    public Set<PixKeyResponseDto> getKeys() {
        return pixOperations.getKeys();
    }
}
