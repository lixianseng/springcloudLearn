package com.aiguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author ：Li Bin
 * @date ： 2021/8/23 22:35
 * @description： 自己写的轮询算法接口
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
