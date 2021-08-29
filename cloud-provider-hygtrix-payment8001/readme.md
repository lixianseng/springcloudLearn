Hystrix是什么

Hystrix是一个用于处理分布式系统的延迟和容错的开源库，在分布式系统里，许多依赖不可避免的会调用失败，比如超时、异常等，Hystrix能够保证在一个依赖出问题的情况下，不会导致整体服务失败，避免级联故障，以提高分布式系统的弹性。

"断路器”本身是一种开关装置，当某个服务单元发生故障之后，通过断路器的故障监控（类似熔断保险丝)，向调用方返回一个符合预期的、可处理的备选响应（FallBack)，而不是长时间的等待或者抛出调用方无法处理的异常，这样就保证了服务调用方的线程不会被长时间、不必要地占用，从而避免了故障在分布式系统中的蔓延，乃至雪崩。

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