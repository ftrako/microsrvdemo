package com.ftrako.orderapisrv.controller.api;

import com.ftrako.orderapisrv.service.PaymentService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 主页
 *
 * @author ftrako
 * @version 1.0 2022-10-26 15:27
 **/
@RestController
@RequestMapping("/v1/order")
public class IndexController {
    private static final Logger logger = LogManager.getLogger(IndexController.class);
    private static final String PAYMENT_URL = "http://PAYMENTAPISRV";

    OkHttpClient client = new OkHttpClient();

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("")
    public String index() {
//        try {
//            String res = doGet(PAYMENT_URL + "/v1/payment");
//            logger.debug("res:" + res);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        String res = restTemplate.getForObject(PAYMENT_URL + "/v1/payment", String.class);
//        ResponseEntity<String> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/v1/payment", String.class);
        logger.debug("res:" + res);

        return "hello, orderapisrv, port:" + port;
    }

    @GetMapping("/feign")
    public String feign() {
        String res = paymentService.getPayment();
        logger.debug("res:" + res);

        return "feign, orderapisrv, port:" + port;
    }

    @GetMapping("/hystrix")
    public String hystrix(@RequestParam String id) {
        String res = paymentService.getHystrix(id);
        logger.debug("hystrix-res:" + res);

        return "hystrix, orderapisrv, port:" + port;
    }

    private String doGet(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
