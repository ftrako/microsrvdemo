package com.ftrako.orderapisrv.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author chendajian
 * @version 1.0
 * 2022-11-09 17:37
 **/
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    @LoadBalanced
//    public RestOperations restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
}
