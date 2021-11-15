package com.zp.controller;

import com.zp.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * PaymentController
 *
 * @author zhengpanone
 * @since 2021-11-15
 */
@RestController
@Slf4j
@RequestMapping("/hystrix")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment/ok/{id}")
    public String paymentInfoOk(@PathVariable("id")Integer id){
        String result =  paymentService.paymentInfo_OK(id);
        log.info("result"+result);
        return result;
    }

    @GetMapping("/payment/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id")Integer id){
        String result =  paymentService.paymentInfo_TimeOut(id);
        log.info("result"+result);
        return result;
    }
}
