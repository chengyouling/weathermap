package com.service.fusionweather.util;

//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {
  @Bean("restProxyTemplate")
  // spring-cloud-huawei基于负载请求
//  @LoadBalanced
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}