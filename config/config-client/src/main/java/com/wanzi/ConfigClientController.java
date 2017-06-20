package com.wanzi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${info.description}")
    String info;

    @RequestMapping(value = "/wanzi")
    public String getInfo(){
        return info;
    }
}
