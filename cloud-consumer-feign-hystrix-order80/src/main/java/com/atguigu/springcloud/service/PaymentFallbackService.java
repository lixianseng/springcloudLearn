package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author ：Li Bin
 * @date ： 2021/8/30 21:54
 * @description：
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id)
    {
        return "-----进入到了全局善后处理的paymentInfo_OK方法 ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id)
    {
        return "-----进入到了全局善后处理的paymentInfo_TimeOut方法 ,o(╥﹏╥)o";
    }
}
