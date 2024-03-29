package com.zp.controller;

import com.zp.entities.CommonResult;
import com.zp.entities.Payment;
import com.zp.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * PaymentController
 *
 * @author zhengpanone
 * @since 2021-10-29
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果*****" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort" + serverPort, result);
        } else {
            return new CommonResult(444, "插入失败,serverPort" + serverPort, null);
        }

    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById != null) {
            return new CommonResult(200, "查询成功,serverPort" + serverPort, paymentById);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID:" + id + "serverPort" + serverPort, null);
        }
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("****************element*************\t" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/afterPredicates")
    public String afterPredicates() {
        return serverPort+"afterPredicates";
    }
    @GetMapping("/beforePredicates")
    public String beforePredicates() {
        return serverPort+"beforePredicates";
    }
    @GetMapping("/betweenPredicates")
    public String betweenPredicates() {
        return serverPort+"betweenPredicates";
    }
    @GetMapping("/headerPredicates")
    public String headerPredicates() {
        return serverPort+"headerPredicates";
    }
    @GetMapping("/cookiePredicates")
    public String cookiePredicates() {
        return serverPort+"cookiePredicates";
    }

    @GetMapping("/hostPredicates")
    public String hostPredicates() {
        return serverPort+"hostPredicates";
    }

    @RequestMapping("/methodPredicates")
    public String methodPredicates() {
        return serverPort+"methodPredicates";
    }

    @GetMapping("/pathPredicates")
    public String pathPredicates() {
        return serverPort+"pathPredicates";
    }

    @GetMapping("/queryPredicates")
    public String queryPredicates() {
        return serverPort+"queryPredicates";
    }

    @GetMapping("/addRequestHeaderFilter")
    public String addRequestHeaderFilter() {
        return serverPort+"addRequestHeaderFilters";
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
