package com.payment_system.controller;

import com.asaas.apisdk.models.*;
import com.payment_system.service.ChargeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/charge")
@AllArgsConstructor
public class ChargeController {

    private final ChargeService chargeService;

    @PostMapping("/createCharge")
    public ResponseEntity<PaymentGetResponseDto> createCharge(@RequestBody PaymentSaveRequestDto body) {
        PaymentGetResponseDto response = chargeService.createCharge(body);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Set<PaymentListResponseDto>> getAllCharge() {
        Set<PaymentListResponseDto> response = chargeService.getAllCharge();
        return ResponseEntity.ok().body(response);

    }
}
