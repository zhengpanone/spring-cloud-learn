package com.zp.controller;

import com.zp.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * PaymentHystrixController
 *
 * @author zhengpanone
 * @since 2021-11-15
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/ok/{id}")
    public String paymentInfoOk(@PathVariable("id")Integer id){
        String result = paymentHystrixService.paymentInfoOk(id);
        log.info(result);
        return result;
    }
    @GetMapping("/payment/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id")Integer id){
        String result = paymentHystrixService.paymentInfoTimeOut(id);
        log.info(result);
        return result;
    }
}
