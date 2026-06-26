package com.payment_system.controller;

import com.asaas.apisdk.models.*;
import com.payment_system.service.PixService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pix")
@AllArgsConstructor
public class PixController {

    private final PixService pixService;

    @PostMapping("/create")
    public ResponseEntity<PixAddressKeyGetResponseDto> createPixKey(@RequestBody PixAddressKeySaveRequestDto body) {
        PixAddressKeyGetResponseDto response = pixService.createPixKey(body);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get")
    public ResponseEntity<Set<PixAddressKeyListResponseDto>> getKeys() {
        Set<PixAddressKeyListResponseDto> response = pixService.getKeys();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/createQrCodePixStatic")
    public ResponseEntity<PixQrCodeSaveResponseDto> createQrCodePixStatic(@RequestBody PixQrCodeSaveRequestDto request) {
        PixQrCodeSaveResponseDto response = pixService.createQrCodePixStatic(request);
        return ResponseEntity.ok().body(response);
    }
}