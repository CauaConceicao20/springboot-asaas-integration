package com.payment_system.dto;

import com.payment_system.infrastructure.enums.formatQRCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record ChargeRequestDto(
        @NotBlank
        String addressKey,
        String description,
        double value,
        formatQRCode format,
        String expirationDate,
        int expirationSeconds,
        boolean allowsMultiplePayments,

        @Size(max = 100, message = "O campo deve conter no máximo 100 caracteres")
        String externalReference

) {
}
