package com.zp.controller;

import com.zp.entities.CommonResult;
import com.zp.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * OrderController
 *
 * @author zhengpanone
 * @since 2021-10-29
 */
@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URI = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URI + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") String id) {
        return restTemplate.getForObject(PAYMENT_URI + "/payment/get/" + id, CommonResult.class);
    }
}
