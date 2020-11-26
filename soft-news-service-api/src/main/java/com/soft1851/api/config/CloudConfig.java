package com.soft1851.api.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author su
 * @className CloudConfig
 * @Description TODO
 * @Date 2020/11/26
 * @Version 1.0
 **/

@Configuration
public class CloudConfig {

    public CloudConfig() {
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
