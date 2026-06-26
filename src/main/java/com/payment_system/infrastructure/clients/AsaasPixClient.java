package com.payment_system.infrastructure.clients;

import com.asaas.apisdk.models.*;
import com.asaas.apisdk.services.PixService;
import com.payment_system.service.interfaces.PixOperations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
public class AsaasPixClient implements PixOperations {

    private final PixService pixService;

    @Override
    public PixAddressKeyGetResponseDto createPixKey(PixAddressKeySaveRequestDto body) {
        return pixService.createAKey(body);
    }

    @Override
    public Set<PixAddressKeyListResponseDto> getKeys() {
        return Set.of(pixService.listKeys());
    }

    @Override
    public PixQrCodeSaveResponseDto createQrCodePixStatic(PixQrCodeSaveRequestDto body) {
        return pixService.createStaticQrcode(body);
    }
}

