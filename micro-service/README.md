Spring Cloud Micro Service with Docker
--

## Option1: 本地搭建

### 一. 本地环境
1. MacOS 10.12.4
2. Docker for Mac
3. Java8
4. Kitematic(Optional)

### 二. 启动
1. 运行启动脚本
 `. ./up.sh` 或者`source ./up.sh`之后执行`.up.sh`
2. 访问consul ui
`http://localhost:8500/ui/`
3. 单独访问`name-service`和`user-service`


---
## Option2: 虚拟机搭建

### 一. 本机
1. vagrant
2. virtualbox

### 二. 虚拟机环境
```bash
$ cd spring-cloud/micro-service/vagrant
$ ls
Vagrantfile  bootstrap.sh
$ vagrant up

```
* vagrant box: comiq/dockerbox(带有`docker`, `docker-machine`和`docker-compose`)
* 创建虚拟机时候会执行`bootstrap.sh`安装`java`，并从github上下载repo

### 三. 启动
1. 登陆到虚拟机中
```bash
$ vagrant ssh
```
2. 运行启动脚本
```bash
vagrant@vagrant:~/Spring-Cloud/micro-service$ ls
Kitematic-UI.png  README.md  docker-compose.yml  name-service  up.sh  user-service  vagrant
vagrant@vagrant:~/Spring-Cloud/micro-service$ . ./up.sh
```
3. 在本机上访问consul ui
`http://localhost:8500/ui/`
4. 在本机上单独访问`name-service`和`user-service`

### 四、负载均衡
>为了启动多台name service容器  
1）在docker-compose.yml文件里删除了`container_name: name-node`  
2）去掉了与docker宿主机的端口映射"8502"，只是暴露端口号给同一网络  

>为了在consul注册同一机器上同一服务的多个实例
默认情况下，Consul实例注册时会使用一个与Spring Application Context ID相同的ID。而默认的Spring Application Context ID是`${spring.application.name}:comma,separated,profiles:${server.port}`。
如果需要保证独立运行，可以使用Spring Cloud的`spring.cloud.consul.discovery.instanceId`这个配置项，来替代默认值。
因此修改了name-service里`application.yml`的instance-id为随机值`${spring.application.name}:${random.value}`

1. 启动多台name service容器
`docker-compose scale name-service=3`
2. 访问consul ui
`http://localhost:8500/ui/`可以看到name-service有三个容器注册其中
![](Consul-UI.png)
3. 查看命令行日志
发现`name-service_1``name-service_2``name-service_3`交替出现


---
## NOTES

### 1. Consul host
获取dokcer宿主机ip，将CONSUL_HOST设置为环境变量。
```bash
# 如果是本机MacOs
ipconfig getifaddr en0

# 如果是虚拟机
hostname -I | awk '{print $1}'
```

### 2. 网络
**Given**`consul-server`的networks为`service-net-1`和`service-net-2`<br>
**And**`name-service`的networks为`service-net-1`<br>
**And**`user-service`的networks为`service-net-2`<br>
**When** 启动up.sh时<br>
**Then**`consul-server`可以和`name-service`通信<br>
**And**`consul-server`可以和`user-service`通信<br>
**And**`name-servicer`**不**可以和`user-service`通信<br>
```yaml
version: '3'
services:
  user-service:
    image: java:8-jre-alpine
    container_name: user-node
    hostname: user-service
    working_dir: /user-service
    command: java -jar user-service-0.0.1-SNAPSHOT.jar
    ports:
      - "8503:8503"
    environment:
      - CONSUL_HOST=${CONSUL_HOST}
    volumes:
      - ./user-service/build/libs/:/user-service
    networks:
      - service-net-2
    depends_on:
      - name-service
    restart: always

  name-service:
    image: java:8-jre-alpine
    container_name: name-node
    hostname: name-service
    working_dir: /name-service
    command: java -jar name-service-0.0.1-SNAPSHOT.jar
    environment:
      - CONSUL_HOST=${CONSUL_HOST}
    volumes:
      - ./name-service/build/libs/:/name-service
    networks:
      - service-net-1
    ports:
      - "8502:8502"
    depends_on:
      - consul
    restart: always

  consul:
    image:  gliderlabs/consul-server:latest
    command: "-advertise=${CONSUL_HOST} -server -bootstrap"
    container_name: consul
    hostname: consul-server
    ports:
      - "8500:8500"
    networks:
      - service-net-1
      - service-net-2

networks:
  service-net-1:
  service-net-2:
```

### 3. Kitematic
Kitematic 完全自动化了 Docker 安装和设置过程，并提供了一个直观的图形用户接口（GUI）来在 Mac 上运行 Docker。
![](Kitematic-UI.png)