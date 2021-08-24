package com.atguigu.springcloud.feign;

import com.aiguigu.springcloud.entity.CommonResult;
import com.aiguigu.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：Li Bin
 * @date ： 2021/8/24 21:00
 * @description：
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")  //这个value来自要调用的那个应用的名称
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}") //这个接口从要调用的接口复制过来就行
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
