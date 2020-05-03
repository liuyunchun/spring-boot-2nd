package com.yunchun.controller;

import com.yunchun.domain.SysCode;
import com.yunchun.repository.SysCodeRepository;
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
    private SysCodeRepository sysCodeRepository;

    @GetMapping("index")
    public String index(Model model){
        List<SysCode> syscodes = sysCodeRepository.findAll();
        model.addAttribute("syscodes", syscodes);
        return "font/syscode/index";
    }

    @GetMapping("add")
    public String add(){
        return "font/syscode/add";
    }

    //redirect
    //forward

    @PostMapping("addsyscode")
    public String addSyscode(Model model, SysCode syscode){
        sysCodeRepository.save(syscode);
        return "font/syscode/index";
    }
}
