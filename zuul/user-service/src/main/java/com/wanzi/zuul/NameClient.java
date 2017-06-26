package com.wanzi.zuul;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("name-service")
public interface NameClient {
    @RequestMapping(method = RequestMethod.GET, value = "/wanzi/names")
    String getName(@RequestParam("name") String name);
}
