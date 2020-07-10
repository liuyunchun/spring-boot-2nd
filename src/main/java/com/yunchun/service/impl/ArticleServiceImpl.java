package com.yunchun.service.impl;

import com.yunchun.domain.Article;
import com.yunchun.repository.ArticleRepository;
import com.yunchun.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Service("com.yunchun.service.impl.ArticleServiceImpl")
public class ArticleServiceImpl extends GenericServiceImpl<Article, ArticleRepository> implements ArticleService{

//    @Resource
//    private ArticleRepository articleRepository;
//
//    @PostConstruct
//    public void init() {setRepository(articleRepository);}

    @Override
    public Article find(String id) {
        return getRepository().findOneById(id);
    }

    @Override
    public List<Article> findAllByTitle(Article article) {
        return getRepository().findAllByTitle(article);
    }

    @Override
    public List<Article> findAllByContent(Article article) {
        return getRepository().findAllByContent(article);
    }

    @Override
    public List<Article> findAllByTitleAndContent(Article article) {
        return getRepository().findAllByTitleAndContent(article);
    }
}
