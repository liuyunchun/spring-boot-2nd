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
    private MemberService memberService;

    @GetMapping("index")
    public String index(Model model){
        List<Member> member = memberService.findAll();
        model.addAttribute("members", member);
        return "/font/member/index";
    }

    @GetMapping("add")
    public String add(){
        return "font/member/add";
    }

    @PostMapping("add-member")
    public String addMember(Model model, Member member){
        member.setCreateTime(LocalDateTime.now());
        memberService.insert(member);
        return "redirect:/member/index";
    }

    @GetMapping("update")
    public String update(Model model, Member item){
        Member member = memberService.find(item.getId());
        model.addAttribute("member",member);
        return "font/member/update";
    }

    @PostMapping("update-member")
    public String updateMember(Model model, Member member){
        memberService.update(member);
        return "redirect:/member/index";
    }

    @GetMapping("find-member")
    public String findMember(Model model, String id){
        Member member = memberService.find(id);
        model.addAttribute("member", member);
        return "font/member/list";
    }

    @GetMapping("delete")
    public String delete(Model model, Member item){
        Member member = memberService.find(item.getId());//為何此行未寫還可以動
        memberService.delete(member);
        return "redirect:/member/index";
    }
}
