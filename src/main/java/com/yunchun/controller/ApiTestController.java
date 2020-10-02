package com.yunchun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("com.yunchun.controller.ApiTestController")
public class ApiTestController {

    @GetMapping("/api")
    public String apiTestForm(){
        return "/font/api/index";
    }
}
