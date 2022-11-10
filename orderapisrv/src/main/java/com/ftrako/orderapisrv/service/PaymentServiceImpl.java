package com.ftrako.orderapisrv.service;

import org.springframework.stereotype.Component;

/**
 * @author chendajian
 * @version 1.0
 * 2022-11-10 09:40
 **/
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String getPayment() {
        return "调用远程服务错误了";
    }

    @Override
    public String getHystrix(String id) {
        return "getHystrix调用远程服务错误了";
    }
}
