package com.bongmall.basic.payment;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PaymentController {
private final PaymentService paymentService;
}
