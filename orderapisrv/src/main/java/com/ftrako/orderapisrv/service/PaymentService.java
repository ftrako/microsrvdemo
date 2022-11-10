package com.ftrako.orderapisrv.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chendajian
 * @version 1.0
 * 2022-11-10 08:41
 **/
@Component
@FeignClient(value = "PAYMENTAPISRV", fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping("/v1/payment")
    String getPayment();

    @GetMapping("/v1/payment/hystrix")
    String getHystrix(@RequestParam("id") String id);
}

