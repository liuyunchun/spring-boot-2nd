package com.yunchun.service.impl;

import com.yunchun.domain.Article;
import com.yunchun.repository.ArticleRepository;
import com.yunchun.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("com.yunchun.service.impl.ArticleServiceImpl")
public class ArticleServiceImpl implements ArticleService{

    @Resource
    private ArticleRepository articleRepository;

    @Override
    public Article insert(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article update(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article find(String id) {
        return articleRepository.findOneById(id);
    }

    @Override
    public void delete(Article article) {
        articleRepository.delete(article);
    }
}
