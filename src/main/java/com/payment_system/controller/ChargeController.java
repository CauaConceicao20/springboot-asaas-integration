package com.payment_system.controller;

import com.payment_system.dto.ChargeListResponseDto;
import com.payment_system.dto.ChargeRequestDto;
import com.payment_system.dto.ChargeResponseDto;
import com.payment_system.service.ChargeService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @GetMapping("/getAll")
    public ResponseEntity<Set<ChargeListResponseDto>> getAllCharge() {
        Set<ChargeListResponseDto> response = chargeService.getAllCharge();
        return ResponseEntity.ok().body(response);

    }
}
