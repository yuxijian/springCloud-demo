package com.vaeyxj.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author yuxijian@jiuxian.com
 * @Date: 2020/2/28 10:29 下午
 */
@FeignClient("eureka-client")
public interface FeignService {

    @RequestMapping("hello")
    String sayHello(@RequestParam("sessionName") String sessionName);

}
