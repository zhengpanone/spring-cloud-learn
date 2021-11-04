package com.zp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * PaymentConsulController
 *
 * @author zhengpanone
 * @since 2021-11-04
 */
@RestController
@RequestMapping("/consul")
public class PaymentConsulController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment")
    public String paymentConsul(){
        return "spring cloud with consul"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
