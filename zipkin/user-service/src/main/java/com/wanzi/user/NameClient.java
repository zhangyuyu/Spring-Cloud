package com.wanzi.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "name-service", fallback = NameClientHystrix.class)
public interface NameClient {
    @RequestMapping(method = RequestMethod.GET, value = "/wanzi")
    String getName(@RequestParam("name") String name);
}
