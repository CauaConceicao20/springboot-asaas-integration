package com.payment_system.service.interfaces;

import com.asaas.apisdk.models.*;

import java.util.Set;

public interface PixOperations {

    PixAddressKeyGetResponseDto createPixKey(PixAddressKeySaveRequestDto body);
    Set<PixAddressKeyListResponseDto> getKeys();
    PixQrCodeSaveResponseDto createQrCodePixStatic(PixQrCodeSaveRequestDto body);

}
