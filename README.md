
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
ps -ef|grep nacos|grep -v grep|wc -l
