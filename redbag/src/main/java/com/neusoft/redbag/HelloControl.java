package com.neusoft.redbag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControl {
    @GetMapping("/")
    public String sayhello(){
        return "Hello8888";
    }
}
