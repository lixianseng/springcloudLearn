package com.aiguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ：Li Bin
 * @date ： 2021/8/16 22:28
 * @description：
 */
@SpringBootApplication
@EnableEurekaClient   //将自己注册进eureka需要的注解
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
