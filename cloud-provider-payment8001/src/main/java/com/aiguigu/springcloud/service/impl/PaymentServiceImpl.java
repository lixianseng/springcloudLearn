package com.aiguigu.springcloud.service.impl;

import com.aiguigu.springcloud.dao.PaymentDao;
import com.aiguigu.springcloud.entity.Payment;
import com.aiguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：Li Bin
 * @date ： 2021/8/15 19:09
 * @description：
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
