package com.yunchun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("com.yunchun.controller.HelloController")
public class HelloController {
    @GetMapping("/hello")
    public String Hello(Model model, @RequestParam("name") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
}
