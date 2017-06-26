Spring Cloud Zuul Demo
---
服务网关是微服务架构中一个不可或缺的部分。通过服务网关统一向外系统提供REST API的过程中，除了具备服务路由、均衡负载功能之外，它还具备了权限控制等功能。
Spring Cloud Netflix中的Zuul就担任了这样的一个角色，为微服务架构提供了前门保护的作用，同时将权限控制这些较重的非业务逻辑内容迁移到服务路由层面，
使得服务集群主体能够具备更高的可复用性和可测试性。
Spring Cloud Zuul包含了对请求的路由和过滤两个功能，其中路由功能负责将外部请求转发到具体的微服务实例上，是实现外部访问统一入口的基础；
而过滤器功能则负责对请求的处理过程进行干预，是实现请求校验、服务聚合等功能的基础。

## 启动
1. 启动consul
`consul agent -dev`
2. 启动`name-service` service
`./gradlew clean bootRun`
3. 启动`user-service` service
`./gradlew clean bootRun`
3. 启动`api-gateway`
`./gradlew clean bootRun`
4. 浏览器访问consul UI
`http://localhost:8500/ui/#/dc1/services`可以看到`name-service`,`user-service`和`api-gateway`已经注册到consul
5. 浏览器分别访问`name-service`和`user-service`
`http://localhost:8502/wanzi/names?name=yu`
`http://localhost:8503/wanzi/users?mobile=1234`
6. 浏览器访问`api-gateway`
`http://localhost:5555/api/name-service/wanzi/names?name=yu`
`http://localhost:5555/api/user-service/wanzi/users?mobile=1234`