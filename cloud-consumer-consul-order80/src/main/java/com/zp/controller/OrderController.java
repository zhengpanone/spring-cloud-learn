package com.zp.controller;

import com.zp.entities.CommonResult;
import com.zp.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Test
 *
 * @author zhengpanone
 * @since 2021-11-04
 */
@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URI = "http://cloud-provider-consul";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consul/payment")
    public String create() {
        return restTemplate.getForObject(PAYMENT_URI + "/consul/payment",String.class);
    }


}
