package com.payment_system.controller;

import com.payment_system.dto.ChargeRequestDto;
import com.payment_system.dto.ChargeResponseDto;
import com.payment_system.service.ChargeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/charge")
@AllArgsConstructor
public class ChargeController {

    private final ChargeService chargeService;

    @PostMapping("/createPix")
        public ResponseEntity<ChargeResponseDto> createCharge(@RequestBody ChargeRequestDto request) {
            ChargeResponseDto response = chargeService.createCharge(request);
            return ResponseEntity.ok().body(response);
        }
}
