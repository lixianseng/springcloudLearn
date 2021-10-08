在Nacos中添加配置信息

Nacos中的dataid的组成格式及与SpringBoot配置文件中的匹配规则

官方文档

说明：之所以需要配置spring.application.name，是因为它是构成Nacos配置管理dataId 字段的一部分。

在 Nacos Spring Cloud中,dataId的完整格式如下：

```yml
${prefix}-${spring-profile.active}.${file-extension}
```



- prefix默认为spring.application.name的值，也可以通过配置项spring.cloud.nacos.config.prefix来配置。
  spring.profile.active即为当前环境对应的 profile，详情可以参考 Spring Boot文档。注意：当spring.profile.active为空时，对应的连接符 - 也将不存在，datald 的拼接格式变成${prefix}.${file-extension}
  file-exetension为配置内容的数据格式，可以通过配置项spring .cloud.nacos.config.file-extension来配置。目前只支持properties和yaml类型。
  通过Spring Cloud 原生注解@RefreshScope实现配置自动更新。



最后公式：

```yaml
${spring.application.name)}-${spring.profiles.active}.${spring.cloud.nacos.config.file-extension}
```



要是启动时候报Could not resolve placeholder 'config.info' in value "${config.info}"的错误

把bootstrap.yml里的group、namespace都注视掉就可以了。