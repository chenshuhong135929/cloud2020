
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

linux环境下安装nacos
解压
tar -zxvf  nacos-server-1.1.4.tar.gz 

linux环境能够识别的ip  
hostname -i 
修改cluster.conf 文件搭建集群
172.18.47.1:3333
172.18.47.1:4444
172.18.47.1:5555


nginx  配置nginx.conf
=====================================================
worker_processes  1;

#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;

#pid        logs/nginx.pid;


events {
    worker_connections  1024;
}

http {
	upstream cluster{
	    server 127.0.0.1:3333;
		server 127.0.0.1:4444;
		server 127.0.0.1:5555;
	}
   server {
        listen       8080;
        server_name  47.112.186.155;

		location /{
           proxy_pass  http://cluster;
        }
  
    }

 }
 
 启动目录  /usr/local/nginx/sbin
 1、启动nginx：./nginx 
 2、关闭nginx：./nginx -s stop
 3、重启nginx：./nginx -s reload

 
    
   
=====================================================
nacos 启动
  
  开启权限（注意不要忘记）
  chmod u+x *.sh
./startup.sh -p 3333
./startup.sh -p 4444
./startup.sh -p 5555

查看开启的应用数量
ps -ef|grep nacos|grep -v grep|wc -l

关闭
./shutdown.sh

===========================================
Sentinel（新提No）
下载地址
https://github.com/alibaba/Sentinel/releases/

java -jar Sentinel.jar  

登陆  用户密码都是（sentinel）




================================
Seata 分布式事务解决方案   

1，以文件形式启动：
（seata 配置需要修改/etc/hosts文件  添加 : (外网ip  本机名称可以使用（hostname）命令进行查找)  （例子： 47.112.186.155  iZwz9iase9sbnjbak0cpszZ） 本机名称可以使用（hostname）命令进行查找
下载seata-server.zar.gz
解压
tar -zxvf  seata-server.zar.gz
修改配置文件  registry.conf  , file.conf
===============================================

docker run --name seata-service --rm -p 8091:8091 -d \
	-e SEATA_IP=47.112.186.155 \
	-e SEATA_CONFIG_NAME=file:/root/seata-config/registry \
	-v /root/alibaba/seata-config/resources/:/root/seata-config \
	-v /root/alibaba/seata-config/log/:/root/logs/  \
          seataio/seata-server:latest
       
语义解析

    -e SEATA_IP=你自己的服务器IP地址 设置IP，使用注册中心时有效
    -e SEATA_CONFIG_NAME=file:/root/seata-config/registry 设置文件映射为容器中的指定目录，registry.conf 为注册文件
    -v /root/alibaba/seata-config/resources/:/root/seata-config 映射当前系统seata-config 下的resources 目录为seata-config
    -v /root/alibaba/seata-config/log/:/root/logs/映射当前系统seata-config 下的log 目录为 日志信息


将配置文件拷贝到 /root/alibaba/seata-config/resources  目录下（registry.conf  file.conf  ）

