package com.vaeyxj.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author yuxijian@jiuxian.com
 * @Date: 2020/2/27 8:45 下午
 */
@RestController
@RefreshScope
public class HelloController {
    @Value("${server.port}")
    private String port;

    @Value("${version}")
    private String name;

    @RequestMapping("hello")
    public String sayHello(@RequestParam("sessionName") String sessionName){
        return "session:"+sessionName+";端口:"+port;
    }

    @RequestMapping("configserver")
    public String configserver(){
        return name;
    }
}
