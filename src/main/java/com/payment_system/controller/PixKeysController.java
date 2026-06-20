package com.payment_system.controller;

import com.payment_system.dto.PixKeyResponseDto;
import com.payment_system.service.PixKeysService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pix")
@AllArgsConstructor
public class PixKeysController {

    private final PixKeysService pixKeysService;

    @PostMapping("/create")
    public ResponseEntity<PixKeyResponseDto> createPixKey() {
        PixKeyResponseDto response = pixKeysService.createPixKey();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get")
    public ResponseEntity<Set<PixKeyResponseDto>> getKeys() {
        Set<PixKeyResponseDto> response = pixKeysService.getKeys();
        return ResponseEntity.ok().body(response);
    }
}