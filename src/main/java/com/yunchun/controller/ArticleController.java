package com.yunchun.controller;

import com.yunchun.domain.Article;
import com.yunchun.domain.Type;
import com.yunchun.service.impl.ArticleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleServiceImpl articleServiceImpl;

    @GetMapping("index")
    public String index(Model model){
        List<Article> article = articleServiceImpl.findAll();
        model.addAttribute("articles", article);
        return "/font/article/index";
    }

    @GetMapping("add")
    public String add(){
        return "font/article/add";
    }

    @PostMapping("addarticle")
    public String addArticle(Model model, Article article){
        article.setId(Integer.toString(randomId()));
        article.setType(Type.ARTICLE);
        article.setCreateTime(LocalDateTime.now());
        articleServiceImpl.insert(article);
        return "redirect:/article/index";
    }

    public int randomId()
    {
        Random ran = new Random();
        return ran.nextInt(30)+1;
    }
}
