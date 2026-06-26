package com.payment_system.controller;

import com.asaas.apisdk.models.CustomerListResponseDto;
import com.payment_system.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/getAll")
    public ResponseEntity <Set<CustomerListResponseDto>> getAllCustomer() {
        return ResponseEntity.ok().body(customerService.getAllCustomer());
    }
}
