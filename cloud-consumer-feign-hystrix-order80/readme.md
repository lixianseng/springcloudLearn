如何使用hystrix来做服务降级？
`@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler"/*指定善后方法名*/,commandProperties = {
             @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
     })
     public String paymentInfo_TimeOut(Integer id)
     {
         try { TimeUnit.MILLISECONDS.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
         return "线程池:  "+Thread.currentThread().getName()+" id:  "+id+"\t"+"O(∩_∩)O哈哈~"+"  耗时(秒): 3";
     }
 
     //用来善后的方法
     public String paymentInfo_TimeOutHandler(Integer id)
     {
         return "线程池:  "+Thread.currentThread().getName()+"  8001系统繁忙或者运行报错，请稍后再试,id:  "+id+"\t"+"o(╥﹏╥)o";
     }`
2.主启动类上加上@EnableCircuitBreaker
3.还要在消费者方的yml上加上
`feign:
   client:
     config:
       default:
         connectTimeout: 60000
         readTimeout: 60000`
不然会报超时的错误，周阳老师的课上没说要加，不知道为啥。