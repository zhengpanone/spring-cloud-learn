package com.zp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * PaymentController
 *
 * @author zhengpanone
 * @since 2021-11-03
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zk")
    private String paymentZookeeper() {
        return "spring cloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
