package com.wanzi.name;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wanzi")
public class NameController {

    @GetMapping
    public String getName(@RequestParam String name) {
        return "Hi ,I'm " + name;
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
