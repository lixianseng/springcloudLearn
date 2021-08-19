package com.atguigu.springcloud.service;

import com.aiguigu.springcloud.entity.Payment;

/**
 * @author ：Li Bin
 * @date ： 2021/8/15 19:08
 * @description：
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
