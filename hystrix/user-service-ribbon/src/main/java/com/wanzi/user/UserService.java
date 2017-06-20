package com.wanzi.user;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getNameError")
    public String getUser(String mobile) {
        String name = restTemplate.getForObject("http://NAME-SERVICE/wanzi?name=yu",String.class);
        return name + ". My mobile is " + mobile;
    }

    public String getNameError(String mobile) {
        return "Sorry, error from name service";
    }

}
