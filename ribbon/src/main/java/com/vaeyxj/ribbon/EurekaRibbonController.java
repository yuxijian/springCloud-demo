package com.vaeyxj.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author yuxijian@jiuxian.com
 * @Date: 2020/2/28 1:58 下午
 */
@RestController
public class EurekaRibbonController {
    @Autowired
    private EurekaRibbonService eurekaRibbonService;

    @RequestMapping("hello")
    public String getHello(){
        String hello = eurekaRibbonService.getHello("ribbon");
        return "Ribbon获得信息：" + hello;
    }
}
