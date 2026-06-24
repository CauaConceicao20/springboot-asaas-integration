package com.payment_system.dto;

public record QrCodePixResponseDto(

        String id,
        String encodedImage,
        String payload,
        String allowsMultiplePayments,
        String expirationDate,
        String externalReference,
        String description
) {
}
