### 消费者自己也可以做熔断降级：

1.yml文件配置：

```yml
#开启
 feign:
   hystrix:
     enabled: true`
```

2.主启动类：@EnableHystrix

3.

```java
@GetMapping("/consumer/payment/hystrix/timeout/{id}")
        @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
                @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
        })
        public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
            //int age = 10/0;
            String result = paymentHystrixService.paymentInfo_TimeOut(id);
            return result;
        }
  //善后方法
   public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
       return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
   }
```

### 全局兜底方法处理：

1.控制器上加上@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")

2.需要兜底的方法上加上@HystrixCommand

3.写一个全局的fallback方法。

### 将降级方法和业务方法解构：

根据消费侧的调远程方法的service，写一个实现类，统一为接口里面的方法进行异常处理。

例如：

PaymentFallbackService类实现PaymentHystrixService接口

```java
@Component
public class PaymentFallbackService implements PaymentHystrixService
{
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

```

YML

```yml
server:
  port: 80

eureka:
  client:
    register-with-eureka: false
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/

#开启
feign:
  hystrix:
    enabled: true

```

PaymentHystrixService接口里加上注解

```java
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT" ,//
             fallback = PaymentFallbackService.class)//指定PaymentFallbackService类
public interface PaymentHystrixService
{
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
```




