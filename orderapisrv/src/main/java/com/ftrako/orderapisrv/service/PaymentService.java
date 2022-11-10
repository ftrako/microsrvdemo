package com.ftrako.orderapisrv.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chendajian
 * @version 1.0
 * 2022-11-10 08:41
 **/
@FeignClient(value = "PAYMENTAPISRV")
public interface PaymentService {
    
    @GetMapping("/v1/payment")
    String getPayment();
}
