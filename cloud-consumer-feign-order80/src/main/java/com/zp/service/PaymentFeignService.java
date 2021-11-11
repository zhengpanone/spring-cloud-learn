package com.zp.service;

import com.zp.entities.CommonResult;
import com.zp.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * OrderService
 *
 * @author zhengpanone
 * @since 2021-11-11
 */
@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {
    /**
     * 根据Id 查询
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);
}
