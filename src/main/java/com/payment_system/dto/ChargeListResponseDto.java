package com.payment_system.dto;

import java.util.Set;

public record ChargeListResponseDto(
        String object,
        String hasMore,
        int totalCount,
        int limit,
        int offset,
        Set<DataPaymentResponseDto> data
) {

    public record DataPaymentResponseDto(
            String object,
            String id,
            String customer,
            String subscription,
            String installment,
            String checkoutSession,
            String paymentLink,
            double value,
            double netValue,
            double originalValue,
            double interestValue,
            String description,
            String billingType,
            CreditCard creditCard,
            boolean canBePaidAfterDueDate,
            String pixTransaction,
            String pixQrCodeId,
            String status,
            String dueDate,
            String originalDueDate,
            String paymentDate,
            String clientPaymentDate,
            String installmentNumber,
            String invoiceUrl,
            String invoiceNumber,
            String dateCreated,
            String confirmedDate,
            String anticipable,
            String lastInvoiceViewedDate,
            String lastBankSlipViewedDate,
            String externalReference,
            boolean deleted,
            boolean anticipated,
            String anticipatedDate,
            String creditDate,
            String estimatedCreditDate,
            String transactionReceiptUrl,
            String nossoNumero,
            String bankSlipUrl,
            Discount discount,
            Fine fine,
            Interest interest,
            Set<Split> split,
            boolean postalService,
            boolean daysAfterDueDateToRegistrationCancellation,
            Chargeback chargeback,
            Escrow escrow,
            Set<Refunds> refunds
    ) {
        public record CreditCard(
                String creditCardNumber,
                String creditCardBrand,
                String creditCardToken

        ) {}

        public record Discount(
                String limitDate,
                double value,
                int dueDateLimitDays,
                String type
        ) {}
        public record Fine(
                double value
        ) {}

        public record Interest(
                String type,
                double value
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
}
