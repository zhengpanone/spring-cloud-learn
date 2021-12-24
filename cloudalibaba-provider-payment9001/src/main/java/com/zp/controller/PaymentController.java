package com.zp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * PaymentController
 *
 * @author zhengpanone
 * @since 2021-12-24
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
@GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id")String id){
        return "nacos registry, serverPort:"+serverPort+"\t id:"+id;
    }
}
