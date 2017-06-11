package com.wanzi.user;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class NameClientHystrix implements NameClient{

    @Override
    public String getName(@RequestParam("name") String name) {
        return "Sorry, error from name service";
    }

}
