package com.yunchun.controller;

import com.yunchun.domain.Member;
import com.yunchun.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller("com.yunchun.controller.FontController")
public class FontController {

    @Resource
    private MemberService memberService;

    @GetMapping("/login")
    public String loginForm() {
        return "/font/login";
    }

    @GetMapping("/logout")
    public String logoutForm(HttpServletRequest request) {
        HttpSession session=request.getSession();
        session.invalidate();
        return "/font/index";
    }

    @GetMapping("/index")
    public String indexForm(HttpServletRequest request) {
        return "/font/index";
    }

    @PostMapping("/loginCheck")
    public String loginCheck(HttpServletRequest request, Model model, Member member) {
        String nextPage = "redirect:/index";

        Member user = memberService.find(member.getId());
        if(user!=null && user.getPassword().compareTo(member.getPassword()) == 0){
            HttpSession session=request.getSession();
            session.setAttribute("userId",user.getId());
        }else{
            nextPage = "redirect:/login";
        }
        return nextPage;
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
