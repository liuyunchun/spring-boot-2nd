package com.yunchun.controller;

import com.yunchun.domain.User;
import com.yunchun.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller("com.yunchun.controller.UserController")
public class UserController {
    @Resource
    private UserService service;

//    @GetMapping("/user-form")
////    public String userForm() {
////        return "demo/demo-form";
////    }
////
////
////    @GetMapping("/user-show")
////    public String show(Model model, @RequestParam("name") String name, @RequestParam("age") int age) {
////        model.addAttribute("name", name);
////        return "demo/demo-show";
////    }
////
////    //    若參數名稱同屬性名稱spring可自動封裝成bean
////    @PostMapping("/user-show")
////    public String postShow(Model model, User user) {
////        model.addAttribute("name", user.getName());
////        return "demo/demo-show";
////    }

    @PostMapping("/user-insert")
    public String insert(Model model, User user) {
        service.insert(user);
        return "User/user-show";
    }

//    @PostMapping("/user-update")
//    public String update(Model model, User user) {
//        service.update(user);
//        return "demo/demo-form";
//    }
//
//    @GetMapping("/user-find")
//    public String find(Model model, @RequestParam("name") String name) {
//        service.find(name);
//        return "demo/demo-form";
//    }
//
//    @GetMapping("/user-delete")
//    public String delete(Model model, @RequestParam("name") String name) {
//        service.delete(name);
//        return "demo/demo-form";
//    }
}
