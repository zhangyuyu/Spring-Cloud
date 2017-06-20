package com.wanzi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wanzi")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUser(@RequestParam String mobile) {
        return userService.getUser(mobile);
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

}
