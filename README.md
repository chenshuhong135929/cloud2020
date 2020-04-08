
Eureka 
Consul 
这里我使用的是docker 启动Consul  命令如下
 docker pull  consul  
 docker run -d --name consul  -p 8500:8500  consul
 
 
 
 可以选择版本高的
 https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/zipkin-server-2.12.9-exec.jar
 运行  java -jar  zipkin-server-2.12.9-exec.jar 
 访问地址：  http://localhost:9411/
 
 下载阿里巴巴的Nacos地址
https://github.com/alibaba/nacos/releases
启动 cmd  bin/startup.cmd
登陆地址 http://192.168.2.17:8848/nacos/
用户密码都是  nacos

