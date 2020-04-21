package com.yunchun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("com.yunchun.controller.FontController")
public class FontController {
    @GetMapping("/index")
    public String indexForm() {
        return "font/index";
    }

    @GetMapping("/single")
    public String singleForm() {
        return "font/single";
    }

    @GetMapping("/category")
    public String categoryForm() {
        return "font/category";
    }
}
