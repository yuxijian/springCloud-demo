package com.vaeyxj.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * @Description
 * @Author yuxijian@jiuxian.com
 * @Date: 2020/2/28 1:49 下午
 */
@Service
public class EurekaRibbonService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFailureInfo")
    public String getHello(String sessionName){
        String message;
        try{
            System.out.println("调用服务 EUREKA-CLIENT/hello");
            message = restTemplate.getForObject("http://EUREKA-CLIENT/hello?sessionName=" + sessionName, String.class);
            System.out.println("调用服务 EUREKA-CLIENT/hello 返回信息" + message);
            System.out.println("调用服务 EUREKA-CLIENT/hello 成功！");
        }catch (Exception e){
            message = e.getMessage();
        }
        return message;
    }

    public String getFailureInfo(String param){
        return "网络繁忙，请稍后重试"+param;
    }
}
