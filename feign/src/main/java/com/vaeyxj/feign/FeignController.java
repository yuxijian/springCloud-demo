package com.vaeyxj.feign;

import org.bouncycastle.tsp.TSPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author yuxijian@jiuxian.com
 * @Date: 2020/2/28 10:32 下午
 */
@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping("hello")
    public String sayHello(){
        String message = null;
        try {
            System.out.println("调用feignservice");
            message = feignService.sayHello("feign");
            System.out.println("调用feigin打印信息："+ message);
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }
        return message;
    }
}
