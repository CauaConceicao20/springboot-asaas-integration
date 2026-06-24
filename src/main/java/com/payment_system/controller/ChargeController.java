package com.payment_system.controller;

import com.payment_system.dto.ChargeRequestDto;
import com.payment_system.dto.ChargeResponseDto;
import com.payment_system.dto.QrCodePixRequestDto;
import com.payment_system.dto.QrCodePixResponseDto;
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
    public ResponseEntity<ChargeResponseDto> createCharge(@RequestBody ChargeRequestDto body) {
        ChargeResponseDto response = chargeService.createCharge(body);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/createQrCodePixStatic")
    public ResponseEntity<QrCodePixResponseDto> createQrCodePixStatic(@RequestBody QrCodePixRequestDto request) {
        QrCodePixResponseDto response = chargeService.createQrCodePixStatic(request);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Set<ChargeResponseDto>> getAllCharge() {
        Set<ChargeResponseDto> response = chargeService.getAllCharge();
        return ResponseEntity.ok().body(response);

    }
}
