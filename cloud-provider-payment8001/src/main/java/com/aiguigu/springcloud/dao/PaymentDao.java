package com.aiguigu.springcloud.dao;

import com.aiguigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：Li Bin
 * @date ： 2021/8/15 19:01
 * @description：
 */
@Mapper
//@Repository不用Spring的
public interface PaymentDao
{
      int create(Payment payment);

      Payment getPaymentById(@Param("id") Long id);
}
