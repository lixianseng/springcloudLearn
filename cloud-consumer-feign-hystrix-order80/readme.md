消费者放自己也可以做熔断降级：
1.yml文件配置：
`#开启
 feign:
   hystrix:
     enabled: true`
2.主启动类：@EnableHystrix

3.`@GetMapping("/consumer/payment/hystrix/timeout/{id}")
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
       