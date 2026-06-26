package com.payment_system.infrastructure.clients;

import com.asaas.apisdk.models.*;
import com.asaas.apisdk.services.PaymentService;

import com.asaas.apisdk.services.PixService;
import com.payment_system.service.interfaces.ChargeOperations;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class AsaasChargeClient implements ChargeOperations {

    private final PaymentService paymentService;

    @Override
    public PaymentGetResponseDto createPayment(PaymentSaveRequestDto body) {
        return paymentService.createNewPayment(body);
    }

    @Override
    public Set<PaymentListResponseDto> getAllCharge() {
        return Set.of(paymentService.listPayments());
    }
}

 /*
PIX

{
  "customer": "cus_000001",
  "billingType": "PIX",
  "value": 150.00,
  "dueDate": "2026-06-30",
  "description": "Pagamento via PIX"
}
*/

/*
BOLETO

{
  "customer": "cus_000001",
  "billingType": "BOLETO",
  "value": 150.00,
  "dueDate": "2026-06-30",
  "description": "Pagamento via boleto",
  "daysAfterDueDateToRegistrationCancellation": 5,
  "postalService": false
}
*/

/*
CARTÃO DE CRÉDITO (À VISTA)

{
  "customer": "cus_000001",
  "billingType": "CREDIT_CARD",
  "value": 150.00,
  "dueDate": "2026-06-30",
  "description": "Pagamento no cartão"
}
*/

/*
CARTÃO DE CRÉDITO PARCELADO (VALOR TOTAL)

{
  "customer": "cus_000001",
  "billingType": "CREDIT_CARD",
  "dueDate": "2026-06-30",
  "installmentCount": 6,
  "totalValue": 600.00,
  "description": "Compra parcelada"
}

O Asaas calcula automaticamente:
600.00 / 6 = 100.00 por parcela
*/

/*
CARTÃO DE CRÉDITO PARCELADO (VALOR DA PARCELA)

{
  "customer": "cus_000001",
  "billingType": "CREDIT_CARD",
  "dueDate": "2026-06-30",
  "installmentCount": 6,
  "installmentValue": 100.00,
  "description": "Compra parcelada"
}

O Asaas calcula automaticamente:
6 x 100.00 = 600.00
*/

/*
EXEMPLO COMPLETO COM DESCONTO, JUROS E MULTA

{
  "customer": "cus_000001",
  "billingType": "PIX",
  "value": 150.00,
  "dueDate": "2026-06-30",
  "description": "Mensalidade",
  "externalReference": "PEDIDO-123",

  "discount": {
    "value": 10,
    "dueDateLimitDays": 3,
    "type": "PERCENTAGE"
  },

  "interest": {
    "value": 1
  },

  "fine": {
    "value": 2,
    "type": "PERCENTAGE"
  }
}
*/
