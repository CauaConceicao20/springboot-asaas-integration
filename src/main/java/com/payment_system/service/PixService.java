package com.payment_system.service;

import com.asaas.apisdk.models.*;
import com.payment_system.infrastructure.utils.QrCodeConverter;
import com.payment_system.service.interfaces.PixOperations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class PixService {

    private final QrCodeConverter qrCodeConverter;

    private final PixOperations pixOperations;

    public PixAddressKeyGetResponseDto createPixKey(PixAddressKeySaveRequestDto body) {
       return pixOperations.createPixKey(body);
    }

    public Set<PixAddressKeyListResponseDto> getKeys() {
        return pixOperations.getKeys();
    }

    public PixQrCodeSaveResponseDto createQrCodePixStatic(PixQrCodeSaveRequestDto body) {
        PixQrCodeSaveResponseDto response = pixOperations.createQrCodePixStatic(body);
        qrCodeConverter.generateQrCodeImage(response.getEncodedImage(), String.valueOf(response.getId()));
        return response;
    }
}
