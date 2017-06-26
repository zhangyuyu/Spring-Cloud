Spring Cloud Demo
--


## 一、Spring Cloud

它并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，
Spring Cloud是一系列框架的有序集合，是一个基于Spring Boot实现的云应用开发工具， 它利用Spring Boot的开发便利性巧妙地简化了分布式系统基础设施的开发，
如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用Spring Boot的开发风格做到一键启动和部署。
通过Spring Boot风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。

---
## 二、 Spring Cloud 的组件

Spring Cloud包含了多个子项目（针对分布式系统中涉及的多个不同开源产品，有近20个之多），比如：
* Spring Cloud Config
* Spring Cloud Netflix
    * Netflix Eureka - 服务注册和服务发现
    * Netflix Hystrix - 监控和断路器
    * Netflix Zuul - 动态路由网关
    * Netflix Archaius - 分布式配置管理
    * Netflix OSS Ribbon - 云端负载均衡
    * Netflix Feign - 声明式、模板化的HTTP客户端
    * Netflix Turbine - 监控聚合
* Spring Cloud Bus - 事件、消息总线, 可与Spring Cloud Config联合实现热部署
* Spring Cloud Sleuth - 日志收集工具包
* Spring Cloud Consul - 封装了Consul操作
* Spring Cloud Zookeeper - 操作Zookeeper的工具包
* Spring Cloud Cluster - 提供Leadership选举
* Spring Cloud Stream - 数据流操作开发包
* Spring Cloud Task - 提供云端计划任务管理、任务调度
* Spring Cloud Connectors - 便于云端应用程序在各种PaaS平台连接到后端
* Spring Cloud for Cloud Foundry - 通过Oauth2协议绑定服务到CloudFoundry
* Spring Cloud Data Flow - 大数据操作工具
* Spring Cloud Security - 基于spring security的安全工具包
* Spring Cloud Starters - 为Spring Cloud提供开箱即用的依赖管理
* Spring Cloud CLI - 快速建立云组件
![](spring-cloud-components.png)

更多详情可以参考[Spring Cloud中文网](https://springcloud.cc/)

---
## 三、相关Demo
* [config](https://github.com/zhangyuyu/Spring-Cloud/blob/master/config/README.md)
* [consul](https://github.com/zhangyuyu/Spring-Cloud/blob/master/consul/README.md)
* [hystrix](https://github.com/zhangyuyu/Spring-Cloud/blob/master/hystrix/README.md)
* [zipkin](https://github.com/zhangyuyu/Spring-Cloud/blob/master/zipkin/README.md)
* [zuul](https://github.com/zhangyuyu/Spring-Cloud/blob/master/zuul/README.md)
* [micro-service](https://github.com/zhangyuyu/Spring-Cloud/blob/master/micro-service/README.md)
该Demo是基于consul在dokcer上搭建的应用。

---
## 四、References
* [Spring Cloud中文网](https://springcloud.cc/)
* [Josh Long 现场演示Spring Cloud Demo](http://ugcbsy.qq.com/flv/238/116/w0509bebaly.m701.mp4?vkey=4F06B3D7AB139CAE211B4AE30BA6214360366B0FD8ACDEBD7F8C75D510BE973CD5C47CFBFF0F38C2E46238BB12DC091D482309F1137FE97407FE7FC72EA65766F0441A607D5EF5F42FB9F333B4FCFF29C8A25D552614D3E0&br=29&platform=2&fmt=auto&level=0&sdtfrom=v1010&guid=45c3ae4bbff5383c0515108875534e0e)
* [Spring Cloud技术分析](http://tech.lede.com/2017/03/15/rd/server/SpringCloud0/)
* [翟永超 Spring Cloud基础教程](http://blog.didispace.com/Spring-Cloud%E5%9F%BA%E7%A1%80%E6%95%99%E7%A8%8B/)
* [纯洁的微笑 Spring Cloud](http://www.ityouknow.com/springcloud/2016/12/30/springcloud-collect.html)
* [许进 跟我学Spring Cloud](http://xujin.org/categories/%E8%B7%9F%E6%88%91%E5%AD%A6Spring-Cloud/)
* [方志朋 Spring Cloud 专栏](http://blog.csdn.net/column/details/15197.html)
* [周立 Spring Cloud](http://www.itmuch.com/)
