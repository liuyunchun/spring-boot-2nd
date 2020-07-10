package com.yunchun.controller;

import com.yunchun.domain.SysCode;
import com.yunchun.repository.SysCodeRepository;
import com.yunchun.service.SysCodeService;
import com.yunchun.service.impl.SysCodeServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/syscode")
public class SysCodeController {
    @Resource
    private SysCodeService sysCodeService;

    @GetMapping("index")
    public String index(Model model){
        Page<SysCode> pageResult = sysCodeService.getPagedSysCodes(0,3);
        model.addAttribute("pageResult", pageResult);
        return "/font/syscode/index";
    }

    @GetMapping("wotuView")
    public String wotuView(Model model, int number,int size){
        Page<SysCode> pageResult = sysCodeService.getPagedSysCodes(number,size);
        model.addAttribute("pageResult",pageResult);
        return "/font/syscode/index";
    }

    //進新增頁面
    @GetMapping("add")
    public String add(){
        return "font/syscode/add";
    }

    //新增
    @PostMapping("add-syscode")
    public String addSyscode(Model model, SysCode syscode){
        sysCodeService.insert(syscode);
        return "redirect:/syscode/index";
    }

    //進修改頁面
    @GetMapping("update")
    public String update(Model model, SysCode item){
        SysCode syscode = sysCodeService.find(item.getId());
        model.addAttribute("syscode",syscode);
        return "font/syscode/update";
    }

    //修改
    @PostMapping("update-syscode")
    public String updateSyscode(Model model, SysCode syscode){
        sysCodeService.update(syscode);
        return "redirect:/syscode/index";
    }

    //查詢
    @GetMapping("find-syscode")
    public String findSyscode(Model model, SysCode syscode){
        List<SysCode> result = new ArrayList<SysCode>();
        if(!syscode.getId().isEmpty() && !syscode.getCode().isEmpty()){
            result = sysCodeService.findByIdAndCode(syscode);
        }else if(!syscode.getId().isEmpty()){
            result = sysCodeService.findAllById(syscode.getId());
        }else if(!syscode.getCode().isEmpty()){
            result = sysCodeService.findAllByCode(syscode.getCode());
        }else{
            result = sysCodeService.findAll();
        }

        model.addAttribute("result", result);
        return "font/syscode/list";
    }

    //刪除
    @GetMapping("delete")
    public String delete(Model model, SysCode item){
        SysCode syscode = sysCodeService.find(item.getId());//為何此行未寫還可以動
        sysCodeService.delete(syscode);
        return "redirect:/syscode/index";
    }
}
