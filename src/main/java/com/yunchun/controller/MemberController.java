package com.yunchun.controller;

import com.yunchun.domain.Member;
import com.yunchun.service.MemberService;
import com.yunchun.service.impl.MemberServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberServiceImpl memberServiceImpl;

    @GetMapping("index")
    public String index(Model model){
        List<Member> member = memberServiceImpl.findAll();
        model.addAttribute("members", member);
        return "/font/member/index";
    }

    @GetMapping("add")
    public String add(){
        return "font/member/add";
    }

    @PostMapping("addmember")
    public String addMember(Model model, Member member){
        member.setCreateTime(LocalDateTime.now());
        memberServiceImpl.insert(member);
        return "redirect:/member/index";
    }
}
