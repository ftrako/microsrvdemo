package com.ftrako.paymentapisrv.controller.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 主页
 *
 * @author ftrako
 * @version 1.0 2022-10-26 15:27
 **/
@RestController
@RequestMapping("/v1/payment")
public class IndexController {
    private static final Logger logger = LogManager.getLogger(IndexController.class);

    @Value("${server.port}")
    private String port;

    @Resource
    private ServiceRegistry serviceRegistry;

    @Resource
    private Registration registration;

    @GetMapping("")
    public String index() {
        logger.debug("hello");
        return "hello, from paymentapisrv2, port:" + port;
    }

    @GetMapping("deregister")
    public String deregister() {
        this.serviceRegistry.setStatus(this.registration, "DOWN");
        this.serviceRegistry.deregister(this.registration);
        return "success";
    }
}
