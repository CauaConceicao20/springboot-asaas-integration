package com.payment_system.dto;

import com.payment_system.infrastructure.enums.BillingType;
import com.payment_system.infrastructure.enums.TypeOfFine;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ChargeRequestDto(
        String customer,
        BillingType billingType,
        LocalDate dueDate,
        String description,
        int daysAfterDueDateToRegistrationCancellation,
        String externalReference,
        String installmentCount,
        BigDecimal value,
        BigDecimal totalValue,
        BigDecimal installmentValue,
        Discount discount,
        Interest interest,
        Fine fine,
        boolean postalService,
        Split split,
        CallBack callBack,
        String pixAutomaticAuthorizationId
) {

    public ChargeRequestDto() {
        this(null, null, null, null, 0,
                null, null, BigDecimal.ZERO ,BigDecimal.ZERO, BigDecimal.ZERO, null, null,
                null, false, null, null, null);
    }

    public record Discount(
            BigDecimal value,
            int dueDateLimitDays,
            TypeOfFine type
    ) {}

    public record Interest(
            BigDecimal value
    ) {}

    public record Fine(
            BigDecimal value,
            TypeOfFine type

    ) {}

    public record Split(
            String walletId,
            String fixedValue,
            String percentualValue,
            BigDecimal totalFixedValue,
            String externalReference,
            String description
    ) {}

    public record CallBack(
            String successUrl,
            boolean autoRedirect
    ) {}
}
