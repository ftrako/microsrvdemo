package com.ftrako.paymentapisrv.controller.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("")
    public String index() {
        logger.debug("hello");
        return "hello, from paymentapisrv, port:" + port;
    }

    @GetMapping("/hystrix")
    public String hystrix(@RequestParam("id") String id) {
        logger.debug("id=" + id);
        int a = 1;
        int b = 0;
        logger.debug(a / b); // 触发panic
        return "hystrix, from paymentapisrv, port:" + port;
    }
}
