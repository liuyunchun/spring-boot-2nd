package com.yunchun.controller;

import com.yunchun.domain.SysCode;
import com.yunchun.repository.SysCodeRepository;
import com.yunchun.service.SysCodeService;
import com.yunchun.service.impl.SysCodeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/syscode")
public class SysCodeController {
    @Resource
    private SysCodeServiceImpl sysCodeServiceImpl;

    @GetMapping("index")
    public String index(Model model){
        List<SysCode> syscodes = sysCodeServiceImpl.findAll();
        model.addAttribute("syscodes", syscodes);
        return "/font/syscode/index";
    }

    @GetMapping("add")
    public String add(){
        return "font/syscode/add";
    }

    //redirect
    //forward

    @PostMapping("addsyscode")
    public String addSyscode(Model model, SysCode syscode){
        sysCodeServiceImpl.insert(syscode);
        return "redirect:/syscode/index";
    }
}
