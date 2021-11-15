package com.zp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
@RequestMapping("/hystrix")
public interface PaymentHystrixService {

    @GetMapping("/payment/ok/{id}")
    public String paymentInfoOk(@PathVariable("id")Integer id);
    @GetMapping("/payment/timeout/{id}")
     String paymentInfoTimeOut(@PathVariable("id")Integer id);
}
