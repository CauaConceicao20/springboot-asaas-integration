package com.payment_system.dto;

import java.util.List;

public record PixKeyResponseDto(
        String totalCount,
        String limit,
        String offset,
        String hasMore,
        List<PixKeyDataDto> data
) {
    public record PixKeyDataDto(
            String id,
            String key,
            String type,
            String status,
            String dateCreated,
            String canBeDeleted,
            String cannotBeDeletedReason,
            QrCodeDataDto qrCode
    ) {
        public record QrCodeDataDto(
                String encodedImage,
                String payload
        ) {
        }
    }
}


