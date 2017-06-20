package com.wanzi.consul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wanzi")
@EnableFeignClients
public class UserController {

    @Autowired
    private NameClient nameClient;

    @GetMapping
    public String getUser(@RequestParam String mobile) {
        String name = nameClient.getName("Yu");
        return name + ". My mobile is " + mobile;
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
