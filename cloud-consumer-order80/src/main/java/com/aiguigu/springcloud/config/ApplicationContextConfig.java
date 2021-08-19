package com.aiguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：Li Bin
 * @date ： 2021/8/16 22:31
 * @description：
 * RestTemplate提供了多种便捷访问远程Http服务的方法，是一种简单便捷的访问restful服务模板类，
 * 是Spring提供的用于访问Rest服务的客户端模板工具集
 *
 * 官网地址
 * 使用：
 * 使用restTemplate访问restful接口非常的简单粗暴无脑。
 * (url, requestMap, ResponseBean.class)这三个参数分别代表。
 * REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
 */
@Configuration
public class ApplicationContextConfig {


    @Bean
    @LoadBalanced////使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
