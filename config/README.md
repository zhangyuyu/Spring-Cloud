Spring Cloud Config Demo
--

Spring Cloud Config为分布式系统中的外部配置提供服务器和客户端支持。
![](spring-cloud-config.png)


## 一、启动
1. 启动config-server
`./gradlew clean bootRun`
2. 浏览器查看配置文件
`http://localhost:8888/config-client/master`
3. 启动config-client
`./gradlew clean bootRun`
4. 浏览器访问config-client
`http://localhost:8881/config-client/wanzi`

## 二、关于配置文件:

### 配置文件在本地的时候
1. 在`${HOME}/Documents/spring-cloud`目录下，放置了两个配置文件`application.properties`和`config-client.properties`
2. 将配置文件所在目录`${HOME}/Documents/spring-cloud`声明为git仓库
3. 并将配置文件`application.properties`和`config-client.properties`添加至git
4. spring.cloud.config.server.git.uri=file://${HOME}/Documents/spring-cloud
```
cd $HOME/Documents/spring-cloud
git init .
echo info.description = This is from local application properties file. > application.properties
echo info.description = This is from local config client dev properties file. > application-dev.properties
git add 

```

## 配置文件在remote git仓库时候
spring.cloud.config.server.git.uri=https://github.com/zhangyuyu/Spring-Cloud

