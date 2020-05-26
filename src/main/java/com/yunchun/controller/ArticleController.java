package com.yunchun.controller;

import com.yunchun.domain.Article;
import com.yunchun.domain.Type;
import com.yunchun.service.ArticleService;
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
    private ArticleService articleService;

    @GetMapping("index")
    public String index(Model model){
        List<Article> article = articleService.findAll();
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
        articleService.insert(article);
        return "redirect:/article/index";
    }

    @GetMapping("update")
    public String update(Model model, Article item){
        Article article = articleService.find(item.getId());
        model.addAttribute("article",article);
        return "font/article/update";
    }

    @PostMapping("updatearticle")
    public String updateArticle(Model model, Article article){
        articleService.update(article);
        return "redirect:/article/index";
    }

    @GetMapping("findarticle")
    public String findArticle(Model model, String id){
        Article article = articleService.find(id);
        model.addAttribute("article", article);
        return "font/article/list";
    }

    @GetMapping("delete")
    public String delete(Model model, Article item){
        Article article = articleService.find(item.getId());//為何此行未寫還可以動
        articleService.delete(article);
        return "redirect:/article/index";
    }




    public int randomId(){
        Random ran = new Random();
        return ran.nextInt(30)+1;
    }
}
