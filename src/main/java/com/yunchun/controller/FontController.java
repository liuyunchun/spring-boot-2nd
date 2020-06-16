package com.yunchun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller("com.yunchun.controller.FontController")
public class FontController {
    @GetMapping("/index")
    public String indexForm(HttpServletRequest request) {
//        user=userrepository.findByuserId();
//        if(user!=null){
//            HttpSession session=request.getSession();
//            session.setAttribute("userId",user.getId());
//        }else{
//
//        }
        return "font/index";
    }
    //列出文章 BY 次數(count)
    //點擊後要載入文章內容(get詳細&留言)

    @GetMapping("/single")
    public String singleForm() {
        return "font/single";
    }
    //點擊留言處要寫入留言
    //自己的文章要可以修改

    @GetMapping("/category")
    public String categoryForm() {
        return "font/category";
    }
    //列出文章 BY 類別
    //點擊後要載入文章內容(get詳細&留言)
}
