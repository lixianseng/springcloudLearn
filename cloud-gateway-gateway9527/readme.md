gateway的配置方式，主要见yml配置文件。

.测试

- 启动7001
- 启动8001-cloud-provider-payment8001
- 启动9527网关

访问说明

添加网关前 - http://localhost:8001/payment/get/1
添加网关后 - http://localhost:9527/payment/get/1
两者访问成功，返回相同结果



还有一种是配置类的方式来配置路由规则，有点麻烦，就当作了解下

```java
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GateWayConfig
{
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_atguigu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
}

```

浏览器输入http://localhost:9527/guonei，返回http://news.baidu.com/guonei相同的页面