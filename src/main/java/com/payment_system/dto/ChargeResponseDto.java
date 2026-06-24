package com.payment_system.dto;

import java.math.BigDecimal;
import java.util.Set;

public record ChargeResponseDto(
        String id,
        String object,
        String hasMore,
        int totalCount,
        int limit,
        String customer,
        String dateCreated,
        BigDecimal value,
        BigDecimal netValue,
        BigDecimal interestValue,
        String billingType,
        String pixTransaction,
        String status,
        String dueDate,
        String originalDueDate,
        String paymentDate,
        String clientPaymentDate,
        String installmentNumber,
        String daysAfterDueDateToRegistrationCancellation,
        String invoiceUrl,
        String invoiceNumber,
        String lastInvoiceViewedDate,
        String lastBankSlipViewedDate,
        Discount discount,
        Fine fine,
        Interest interest,
        boolean postalService,
        String digitalAccount,
        String subscription,
        String installment,
        String creditCard,
        boolean canBePaidAfterDueDate,
        String pixQrCodeId,
        String pixQrCode,
        String pixExpirationDate,
        String confirmedDate,
        Escrow escrow,
        Set<Refunds> refunds,
        String externalReference,
        boolean deleted,
        boolean anticipated,
        boolean anticipable,
        String creditDate,
        String estimatedCreditDate,
        String transactionReceiptUrl,
        String nossoNumero,
        String bankSlipUrl,
        BigDecimal originalValue,
        String description,
        String paymentLink,
        String checkoutSession,
        int offset,
        Set<DataPaymentResponseDto> data
) {

    public record DataPaymentResponseDto(
            CreditCard creditCard,
            Set<Split> split,
            Chargeback chargeback,
            String anticipatedDate
    ) {
        public record CreditCard(
                String creditCardNumber,
                String creditCardBrand,
                String creditCardToken

        ) {}

        public record Split(
                String id,
                String walletId,
                String fixedValue,
                String percentualValue,
                double totalValue,
                String cancellationReason,
                String status,
                String externalReference,
                String description
        ) {}

        public record Chargeback(
                String id,
                String payment,
                String installment,
                String customerAccoun,
                String status,
                String reason,
                String disputeStartDate,
                String value,
                String paymentDate,
                CreditCard creditCard,
                String disputeStatus,
                String deadlineToSendDisputeDocuments
        ) {}


    }
    public record Discount(
            String limitDate,
            double value,
            int dueDateLimitDays,
            String type
    ) {}

    public record Fine(
            String type,
            double value
    ) {}

    public record Interest(
            String type,
            double value
    ) {}

    public record Escrow(
            String id,
            String status,
            String expirationDate,
            String finishDate,
            String finishReason
    ) {}

    public record Refunds(
            String dateCreated,
            String status,
            double value,
            String endToEndIdentifier,
            String description,
            String effectiveDate,
            String transactionReceiptUrl,
            Set<RefundedSplits> refundedSplits
    ) {
        public record RefundedSplits(
                String id,
                double value,
                boolean done
        ) {}
    }
}
