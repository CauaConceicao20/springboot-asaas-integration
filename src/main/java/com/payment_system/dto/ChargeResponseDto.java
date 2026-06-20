package com.payment_system.dto;

public record ChargeResponseDto(

        String id,
        String encodedImage,
        String payload,
        String allowsMultiplePayments,
        String expirationDate,
        String externalReference,
        String description
) {
}
