package com.chenshuhong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @auther zzyy
 * @create 2020-02-19 23:57
 * 给用户以暴露接口的显示调用微服务
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80
{
    public static void main(String[] args) {
            SpringApplication.run(OrderFeignMain80.class, args);
    }
}
