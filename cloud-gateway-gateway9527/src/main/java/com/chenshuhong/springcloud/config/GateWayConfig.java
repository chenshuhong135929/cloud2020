package com.chenshuhong.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther zzyy
 * @create 2020-02-21 11:42
 */
@Configuration
public class GateWayConfig
{
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_chenshuhong",//路由的ID，没有固定规则但要求唯一，建议配合服务名
                r -> r.path("/guonei")//断言，路径相匹配的进行路由
                        .uri("http://news.baidu.com/guonei")).build();//匹配后提供服务的路由地址
        /**
         * 这里重复可以配置多个
         */
        routes.route("path_route_chenshuhong11",//路由的ID，没有固定规则但要求唯一，建议配合服务名
            r -> r.path("/guonei1")//断言，路径相匹配的进行路由
                .uri("https://www.bilibili.com/video/BV1yE411x7Ky?p=70")).build();//匹配后提供服务的路由地址
        return routes.build();
    }
}
